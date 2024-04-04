{
   2. Una agencia dedicada a la venta de autos ha organizado su stock y, dispone en papel de la
información de los autos en venta. Implementar un programa que:
a) Lea la información de los autos (patente, año de fabricación (2010..2018), marca y
modelo) y los almacene en dos estructuras de datos:
i. Una estructura eficiente para la búsqueda por patente.
ii. Una estructura eficiente para la búsqueda por marca. Para cada marca se deben
almacenar todos juntos los autos pertenecientes a ella.
b) Invoque a un módulo que reciba la estructura generado en a) i y una marca y retorne
la cantidad de autos de dicha marca que posee la agencia.
c) Invoque a un módulo que reciba la estructura generado en a) ii y una marca y retorne
la cantidad de autos de dicha marca que posee la agencia.
d) Invoque a un módulo que reciba el árbol generado en a) i y retorne una estructura con
la información de los autos agrupados por año de fabricación.
e) Invoque a un módulo que reciba el árbol generado en a) i y una patente y devuelva el
modelo del auto con dicha patente.
f) Invoque a un módulo que reciba el árbol generado en a) ii y una patente y devuelva el
modelo del auto con dicha patente.
   
   
}


program repaso2;
type
	ano = 2010..2018;
	
	auto = record
		anio: ano;
		patente: integer;
		marca: string;
		modelo:string;
	end;
	
	arbolA = ^nodoA;
	nodoA = record
		dato: auto;
		hi,hd: arbolA;
	end;
	
	listaB = ^nodoLB;
	nodoLB = record
		patente: integer;
		modelo: string;
		anio: ano;
		sig: listaB;
	end;
	
	arbolB = ^nodoB;
	nodoB = record
		marca: string;
		dato: listaB;
		hi,hd: arbolB;
	end;
	
	listaD = ^nodoLD;
	nodoLD = record
		patente: integer;
		modelo: string;
		marca: string;
		sig: listaD;
	end;
	
	
	vector = array[ano] of listaD;
	

procedure leerAuto(var r:auto);
begin
	readln(r.patente);
	if(r.patente <> -1) then begin
		readln(r.anio);
		readln(r.marca);
		readln(r.modelo);
	end;
end;

procedure agregarArbolA(var a:arbolA; r:auto);
begin
	if(a = nil) then begin
		new(a);
		a^.dato:= r;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else
		if(r.patente < a^.dato.patente) then
			agregarArbolA(a^.hi,r)
		else
			agregarArbolA(a^.hd,r)	
end;

procedure agregarLista(var l:listaB; r:auto);
var
	nue:listaB;
begin
	new(nue);
	nue^.patente:= r.patente;
	nue^.anio:= r.anio;
	nue^.modelo:= r.modelo;
	nue^.sig:= l;
	l:= nue;
end;

procedure agregarArbolB(var a:arbolB; r:auto);
begin
	if(a = nil) then begin
		new(a);
		a^.marca:= r.marca;
		a^.dato:= nil;
		agregarLista(a^.dato,r);
		end
		else
			if(r.marca = a^.marca) then
				agregarLista(a^.dato,r)
			else
				if(r.marca < a^.marca) then
					agregarArbolB(a^.hi,r)
				else
					agregarArbolB(a^.hd,r)
end;

procedure cargarArboles(var a:arbolA; var a2:arbolB );
var
	r: auto;
begin
	leerAuto(r);
	while(r.patente <> -1) do begin
		agregarArbolA(a,r);
		agregarArbolB(a2,r);
		leerAuto(r);
	end;
end;
	
procedure contarA(a:arbolA; x:string; var y:integer);
begin
	if(a <> nil) then begin
		contarA(a^.hi,x,y);
		if(a^.dato.marca = x) then
			y:= y + 1;	
		contarA(a^.hd,x,y);
	end;	
end;	
	
procedure contarMarcaA(a:arbolA);
var 
	y:integer;
	x:string;
begin
	y:= 0;
	readln(x);
	contarA(a,x,y);
	write(y);
end;	
	
function buscarB(a:arbolB; x:string):listaB;
begin
	if(a = nil) then
		buscarB:= nil
	else
		if(a^.marca = x) then 
			buscarB:= a^.dato
		else
			if(x < a^.marca) then
				buscarB:= buscarB(a^.hi,x)		
			else
				buscarB:= buscarB(a^.hd,x)	
end;	
	
function contarB(l:listaB):integer;	
var
	y: integer;
begin
	y:= 0;
	while(l <> nil) do begin
		y:= y + 1;
		l:= l^.sig;
	end;
		contarB:= y;
end;
	
procedure contarMarcaB(a:arbolB);
var
	x:string;
	y: listaB;
begin
	readln(x);
	y:=nil;
	y:=buscarB(a,x);
	if (y = nil) then
		write('no se encontro la marca')
	else	
		writeln(contarB(y));
end;	
	
procedure iniciarVector(var v:vector);
var
	i:integer;
begin
	for i:= 1 to 8 do 
		v[i]:= nil;
end;		
	
procedure agregarListaD(var l:listaD; a:arbolA);
var
	nue:listaD;
begin
	new(nue);
	nue^.patente:= a^.dato.patente;
	nue^.marca:= a^.dato.marca;
	nue^.modelo:= a^.dato.modelo;
	nue^.sig:= l;
	l:= nue;
end;	
	
procedure cargarVector(a:arbolA;var v:vector);
begin
	if(a <> nil) then begin
		cargarVector(a^.hi,v);
		agregarListaD(v[a^.dato.anio],a);
		cargarVector(a^.hd,v);
	end;
end;	
	
function buscarPA(a:arbolA; x:integer):string;
begin
	if(a = nil) then
		buscarPA:= 'no se encontro'
	else
		if(a^.dato.patente = x) then 
			buscarPA:= a^.dato.modelo
		else
			if(x < a^.dato.patente) then
				buscarPA:= buscarPA(a^.hi,x)		
			else
				buscarPA:= buscarPA(a^.hd,x)	
end;		
	
procedure buscarPatenteA(a:arbolA);	
var
	y:integer;
begin
	readln(y);
	writeln(buscarPA(a,y));
		
end;

procedure buscarPatente_ii(a:arbolListas);
    procedure busqueda(a:arbolListas;p:string);
    var
        encontrada:boolean;
        aux:lista;
        
    begin
        encontrada:=false;
        if (a = nil) then
            writeln('Patente no encontrada')
        else  begin 
            aux:=a^.dato.auto;
            while (aux <> nil) do begin
                if (aux^.dato.patente = p) then begin
                    writeln('Patente ',p,' encontrada');
                    encontrada:=true;
                end;
                aux:=aux^.sig;
            end;
            if not encontrada then begin
                busqueda(a^.hi,p);
                busqueda(a^.hd,p);
            end;
        end;
    end;


	
var
	a: arbolA;
	a2: arbolB;
	v: vector;
	
BEGIN
	a:= nil;
	a2:= nil;
	cargarArboles(a,a2);
	if(a = nil )then
		writeln('arbol vacio')
	else	
		contarMarcaA(a);
		iniciarVector(v);
		cargarVector(a,v);
		
	if(a2= nil )then
		writeln('arbol vacio')
	else	
		contarMarcaB(a2);
	
END.


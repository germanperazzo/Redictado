{
 1. Escribir un programa que:
a. Implemente un módulo que lea información de socios de un club y las almacene en un árbol
binario de búsqueda. De cada socio se lee número de socio, nombre y edad. La lectura finaliza
con el número de socio 0 y el árbol debe quedar ordenado por número de socio.
b. Una vez generado el árbol, realice módulos independientes que reciban el árbol como
parámetro y que :
i. Informe el número de socio más grande. Debe invocar a un módulo recursivo que
retorne dicho valor.
ii. Informe los datos del socio con el número de socio más chico. Debe invocar a un
módulo recursivo que retorne dicho socio.
iii. Informe el número de socio con mayor edad. Debe invocar a un módulo recursivo que
retorne dicho valor.
iv. Aumente en 1 la edad de todos los socios.
v. Lea un valor entero e informe si existe o no existe un socio con ese valor. Debe invocar a
un módulo recursivo que reciba el valor leído y retorne verdadero o falso.
vi. Lea un nombre e informe si existe o no existe un socio con ese nombre. Debe invocar a
un módulo recursivo que reciba el nombre leído y retorne verdadero o falso.
vii. Informe la cantidad de socios. Debe invocar a un módulo recursivo que retorne dicha
cantidad.
viii. Informe el promedio de edad de los socios. Debe invocar al módulo recursivo del
inciso vii e invocar a un módulo recursivo que retorne la suma de las edades de los socios.
xi. Informe los números de socio en orden creciente.
x. Informe los números de socio pares en orden decreciente.
   
}


program untitled;
type
	
	socio = record
		num: integer;
		nombre: string;
		edad: integer; 
	end;

	arbol = ^nodo;
	nodo = record
		dato: socio;
		hi: arbol;
		hd: arbol;
	end;
	
procedure informarSiExite(a:arbol);
	function buscar(a: arbol; x: integer):boolean;
	begin
		if(a = nil) then 
			buscar:= false
		else
			if(a^.dato.num = x ) then 
				buscar:= true
			else
				if(x < a^.dato.num) then
					buscar:=buscar(a^.hi,x)
				else
					buscar:=buscar(a^.hd,x);
	end;
var
	x:integer;
begin
	readln(x);
	if(buscar(a,x)) then 
		writeln('si existe' , x)
	else
		writeln('no existe' , x)		
end;	

procedure informarSiExiteSocio(a:arbol);
	function buscarM(a: arbol; x: string):boolean;
	begin
		if(a = nil) then 
			buscarM:= false
		else
			if(a^.dato.nombre = x ) then 
				buscarM:= true
			else
				if(x < a^.dato.nombre) then
					buscarM:=buscarM(a^.hi,x)
				else
					buscarM:=buscarM(a^.hd,x)
	end;

var
	x:string;
begin
	readln(x);
	if(buscarM(a,x)) then 
		writeln('si existe' , x)
	else
		writeln('no existe' , x)
end;
	
procedure leerSocio(var r: socio);
begin
	readln(r.num);
	if(r.num <> 0 )then begin
		readln(r.nombre);
		readln(r.edad);
	end;
end;

procedure agregarSocio(var a: arbol; r: socio);
begin
	if(a = nil) then begin
		new(a);
		a^.dato:= r;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else
		if(r.num < a^.dato.num) then
			agregarSocio(a^.hi,r)
		else
			agregarSocio(a^.hd,r);		
end;

procedure armarArbol(var a: arbol);
var
	r: socio;
begin
	leerSocio(r);
	while (r.num <> 0) do begin
		agregarSocio(a,r);
		leerSocio(r);
	end;	
end;

function socioMasGrande(a:arbol):integer;
begin
	if(a^.hd = nil ) then 
		socioMasGrande:= a^.dato.num
	else
		socioMasGrande:= socioMasGrande(a^.hd);	
end;

function socioMasChico(a:arbol):arbol;
begin
	if(a^.hi = nil) then
		socioMasChico:= a
	else 
		socioMasChico:= socioMasChico(a^.hi);	
end;

procedure informarDatos(a:arbol);
var
	x: arbol;
begin
	x:=socioMasChico(a);
	writeln(x^.dato.num);
	writeln(x^.dato.edad);
	writeln(x^.dato.nombre);
end;

procedure maximaEdad(a:arbol);
	procedure buscarMax(a:arbol;var maxEdad1:integer;var maxNum1:integer);
	begin
		if(a <> nil) then begin
			if(a^.dato.edad > maxEdad1) then begin
				maxEdad1:= a^.dato.edad;
				maxNum1:= a^.dato.num;
			end;
			buscarMax(a^.hi,maxEdad1,maxNum1);
			buscarMax(a^.hd,maxEdad1,maxNum1);
		end
	end;
var
	maxNum,maxEdad:integer;
begin
	maxEdad:=-1;
	buscarMax(a,maxEdad,maxNum);
	writeln(maxNum);
end;

procedure aumentarEdad(a:arbol);
begin
	if (a <> nil ) then begin
		a^.dato.edad:= a^.dato.edad +1;
		aumentarEdad(a^.hi);
		aumentarEdad(a^.hd);
	end;
end;

function contar(a: arbol):integer;
	begin
		if (a = nil) then 
			contar:=0
		else 
			contar:= 1 + contar (a^.HI) + contar(a^.HD);   
	end;

procedure informarCantSocios(a:arbol);
begin
	writeln(contar(a));
end;

function sumar(a: arbol):integer;  
begin
 if (a = nil) then begin
	sumar:=0;
	end else begin
        sumar:= a^.dato.edad + sumar (a^.HI) + sumar(a^.HD);
    end;    
end;  
  

procedure informarPromedio(a:arbol);
begin
	writeln(sumar(a)/contar(a));
end;

procedure InformarNumerosSociosOrdenCreciente(a: arbol);
begin
  if (a <> nil) then begin
    InformarNumerosSociosOrdenCreciente(a^.HI);
    writeln('Numero de socio: ', a^.dato.num);
    InformarNumerosSociosOrdenCreciente(a^.HD);
  end;
end;


procedure InformarNumerosSociosOrdenDeCreciente(a: arbol);
begin
  if (a <> nil) then begin
    InformarNumerosSociosOrdenDeCreciente(a^.HD);
    if (a^.dato.num mod 2 = 0) then begin
      writeln('Numero de socio: ', a^.dato.num);
    end;
    InformarNumerosSociosOrdenDeCreciente(a^.HI);
  end;
end;


var 
	a: arbol;
BEGIN
	a:=nil;
	armarArbol(a);
	if (a = nil) then
		writeln('arbol vacio')
	else begin
		writeln(socioMasGrande(a));
		informarDatos(a);
		maximaEdad(a);
		aumentarEdad(a);
		informarSiExite(a);
		informarSiExiteSocio(a);
		informarCantSocios(a);
		InformarNumerosSociosOrdenDeCreciente(a);
		InformarNumerosSociosOrdenCreciente(a);
	end;	
END.



program examen03;
type
	rangoDias= 1..31;
	
	compraAGuardar = record
		monto: real;
		dia: rangoDias;
		cant: integer;
	end;

	
	compra = record
		cod: integer;
		ag: compraAGuardar;
	end;
	
	
	lista = ^nodoL;
	nodoL = record
		dato: compraAGuardar;
		sig: lista;
	end;
	

	arbol = ^nodoA;
	nodoA = record
		cod: integer;
		dato: lista;
		hi,hd: arbol;
	end;
	

procedure leerCompra(var r:compra);
begin
	r.ag.cant:= random(30);
	if(r.ag.cant <> 0) then begin
		r.cod:= 1 + Random(99);
		r.ag.monto:= 150.80 + Random(8000);
		r.ag.dia:= 1+ Random(31);
	end;
end;

procedure agregarLista(var l:lista; r:compraAGuardar);
var
	nue: lista;
begin
	new(nue);
	nue^.dato:= r;
	nue^.sig:= l;
	l:= nue;
end;

procedure agregarArbol(var a:arbol; r:compra);

begin
	if(a = nil) then begin
		new(a);
		a^.cod:= r.cod;
		a^.dato:= nil;
		agregarLista(a^.dato,r.ag);	
		a^.hd:= nil;
		a^.hi:= nil;
	end
	else
		if(r.cod = a^.cod)then
			agregarLista(a^.dato,r.ag)
		else
			if(r.cod < a^.cod) then
				agregarArbol(a^.hi,r)
			else
				agregarArbol(a^.hd,r)		
end;

procedure generarArbol(var a :arbol);
var
	r: compra;
begin
	leerCompra(r);
	while(r.ag.cant <> 0) do begin
		agregarArbol(a,r);
		leerCompra(r);
	end;
end; 

function buscar(a:arbol; x:integer):lista;
begin
	if(a = nil) then
		buscar:= nil
	else
		if(a^.cod = x) then
			buscar:= a^.dato
		else
			if(x < a^.cod) then
				buscar:= buscar(a^.hi,x)
			else
				buscar:= buscar(a^.hd,x)			
end;

procedure buscarCompras(a:arbol; var l:lista);
var 
	x:integer;
begin
	readln(x);
	l:= buscar(a,x);
end;

procedure buscarMax(l:lista; var maxCant: integer; var maxMonto: real );
begin
	if(l <> nil) then begin
		if(l^.dato.cant > maxCant) then
			maxCant:= l^.dato.cant;
			maxMonto:= maxMonto; 
		buscarMax(l^.sig,maxCant,maxMonto);
	end;
end;

procedure buscarMayor(l:lista;var x:real);
var
	maxCant: integer;
	maxMonto: real;
begin
	maxCant:= -1;
	maxMonto:= -1;
	buscarMax(l,maxCant,maxMonto);
	x:= maxMonto;
end;

var 
	a: arbol;
	l: lista;
	x: real;
BEGIN
	randomize;
	a:= nil;
	generarArbol(a);
	if(a= nil) then
		writeln('arbol vacio')
	else
		l:= nil;	
		buscarCompras(a,l);	
		buscarMayor(l,x);
END.


{
2.- Implementar un programa que procese información de propiedades que están a la venta
en una inmobiliaria.
Se pide:
a) Implementar un módulo para almacenar en una estructura adecuada, las propiedades
agrupadas por zona. Las propiedades de una misma zona deben quedar almacenadas
ordenadas por tipo de propiedad. Para cada propiedad debe almacenarse el código, el tipo de
propiedad y el precio total. De cada propiedad se lee: zona (1 a 5), código de propiedad, tipo
de propiedad, cantidad de metros cuadrados y precio del metro cuadrado. La lectura finaliza
cuando se ingresa el precio del metro cuadrado -1.
b) Implementar un módulo que reciba la estructura generada en a), un número de zona y un
tipo de propiedad y retorne los códigos de las propiedades de la zona recibida y del tipo
recibido.
   
}


program practica0e2;
type

	porpiedadAGuardar = record
		cod: integer;
		tipo: integer;
		precioP: real;
	end;

	propiedad = record
		zona: 1..5;
		cantM: real;
		precioM: real;
		ag: porpiedadAGuardar;
	end;

	listaP = ^nodo;
	nodo = record
		dato: porpiedadAGuardar;
		sig: listaP;
	end;	
	
	vecPropiedades = array [1..5] of listaP;

	listaP2 = ^nodo2;
	nodo2 = record
		dato: integer;
		sig: listaP2;
	end;
	
procedure iniciarVetor(var v: vecPropiedades);
var 
	i: integer;
begin
	for i:= 1 to 5 do begin
		v[i]:= nil;
	end;
end;	

procedure leerPropiedad(var p: propiedad);
begin
	readln(p.precioM);
	if(p.precioM <> -1) then begin
		readln(p.zona);
		readln(p.cantM);
		p.ag.precioP:= (p.precioM * p.cantM); 
		readln(p.ag.cod);
		readln(p.ag.tipo);	
	end;
end;

procedure insertarOrdenado(var l:listaP; p:porpiedadAGuardar);
var
	act,ant,nue: listaP;
begin
	new(nue); nue^.dato:= p; nue^.sig:= nil;
	if(l = nil) then l:= nue
	else begin
		act:=l; ant:=l;
		while(act <> nil) and (act^.dato.tipo < nue^.dato.tipo) do begin
			ant:= act;
			act:= act^.sig;
		end;
	end;
	if(act = l ) then begin
		nue^.sig:= l;
		l:= nue;
	end
	else begin
		ant^.sig:= nue;
		nue^.sig:= act;
	end;		
end;

procedure cargarPropeidades(v: vecPropiedades);
var 
	p:propiedad;
begin
	leerPropiedad(p);
	while(p.precioM <> -1) do begin
		insertarOrdenado(v[p.zona],p.ag);
		leerPropiedad(p);
	end;
end;

procedure agregarAdelante(var l:listaP2; x:integer);
var
	nue: listaP2;
begin
	new(nue); 
	nue^.dato:= x; 
	nue^.sig:= nil;
	l:= nue;	
end;

procedure crearLista2(v :vecPropiedades; z: integer ; t:integer; var l:listaP2 );
begin
	while (v[z] <> nil) do begin
		if(v[z]^.dato.cod = t )then agregarAdelante(l,v[z]^.dato.cod);
		v[z]:= v[z]^.sig;
	end;
end;	

var 
	v: vecPropiedades;
	l: listaP2;
	z,t: integer;
BEGIN
	l:= nil;
	iniciarVetor(v);
	cargarPropeidades(v);
	readln(z);
	readln(t);
	crearLista2(v,z,t,l);
END.


{
2. Escribir un programa que:
a. Implemente un módulo que lea información de ventas de un comercio. De cada venta se lee
código de producto, fecha y cantidad de unidades vendidas. La lectura finaliza con el código de
producto 0. Un producto puede estar en más de una venta. Se pide:
i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de
producto.
ii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por
código de producto. Cada nodo del árbol debe contener el código de producto y la
cantidad total de unidades vendida.
Nota: El módulo debe retornar los dos árboles.
b. Implemente un módulo que reciba el árbol generado en i. y un código de producto y retorne
la cantidad total de unidades vendidas de ese producto.
c. Implemente un módulo que reciba el árbol generado en ii. y un código de producto y retorne
la cantidad total de unidades vendidas de ese producto.
   
}


program untitled;
type

	venta = record
		cod: integer;
		fecha: integer;
		cant: integer;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato: venta;
		hd: arbol;
		hi: arbol;
	end;
	
	arbol2 = ^nodo2;
	nodo2 = record
		cod: integer;
		cant: integer;
		hd: arbol2;
		hi: arbol2;
	end;

procedure leerVenta(var r: venta);
begin
	readln(r.cod);
	if (r.cod <> 0) then begin
		readln(r.fecha);
		readln(r.cant);
	end;
end;
	
procedure agregarArbol(var a: arbol; r:venta);
begin
	if (a = nil) then begin
		new(a);
		a^.dato:= r;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else
		if(r.cod < a^.dato.cod) then
			agregarArbol(a^.hi,r)
		else
			agregarArbol(a^.hd,r)
end;	
	
procedure agregarArbol2(var a2: arbol2; r:venta);
begin
	if (a2 = nil) then begin
		new(a2);
		a2^.cod:= r.cod;
		a2^.cant:= r.cant;
		a2^.hi:= nil;
		a2^.hd:= nil;
	end
	else
		if(r.cod = a2^.cod) then
			a2^.cant:= a2^.cant + r.cant
		else	
			if(r.cod < a2^.cod) then
				agregarArbol2(a2^.hi,r)
			else
				agregarArbol2(a2^.hd,r)
end;		
	
procedure armarArboles(var a: arbol;var a2: arbol2);
var
	r:venta;
begin
	leerVenta(r);
	while (r.cod <> 0) do begin
		agregarArbol(a,r);
		agregarArbol2(a2,r);
		leerVenta(r);
	end;
end;
	
function buscarArbol2(a2: arbol2; x:integer):integer;
begin
	if(a2 = nil) then 
		buscarArbol2:= -1
	else
		if(a2^.cod = x) then 
			buscarArbol2:= a2^.cant
		else
			if(a2^.cod < x) then
				buscarArbol2(a2^.hi,x)
			else
				buscarArbol2(a2^.hd,x)	
end;
	
procedure buscarArbol (a: arbol; x: integer; var total: integer);
begin
	if(a <> nil) then begin
		buscarArbol(a^.hi,x,total);
		if(a^.dato.cod = x) then
			total:= total + a^.dato.cant;
		buscarArbol(a^.hd,x,total);	
	end
end;	
	
var 
	a:arbol;
	a2:arbol2;
	x,z,w,y: integer;
BEGIN
	armarArboles(a,a2);
	readln(x);
	if(a2 = nil)then
		writeln('.')
	else
		z:=buscarArbol2(a2,x);
		if (z <> -1) then
			writeln(z);
	readln(y);		
	if(a = nil)then
		writeln('.')
	else
		w:=buscarArbol2(a2,y);
		if (w <> -1) then
			writeln(w);	
END.


{
 1. Implementar un programa modularizado para una librería que:
2. Almacene los productos vendidos en una estructura eficiente para la búsqueda por código
de producto. De cada producto deben quedar almacenados la cantidad total de unidades
vendidas y el monto total. De cada venta se lee código de venta, código del producto
vendido, cantidad de unidades vendidas y precio unitario. El ingreso de las ventas finaliza
cuando se lee el código de venta -1.
a. Imprima el contenido del árbol ordenado por código de producto.
b. Contenga un módulo que reciba la estructura generada en el punto a y retorne el
código de producto con mayor cantidad de unidades vendidas.
c. Contenga un módulo que reciba la estructura generada en el punto a y un código de
producto y retorne la cantidad de códigos menores que él que hay en la estructura.
d. Contenga un módulo que reciba la estructura generada en el punto a y dos códigos de
producto y retorne el monto total entre todos los códigos de productos comprendidos
entre los dos valores recibidos (sin incluir).
   
   
}


program practica04e1;
type
	venta = record
		codVen: integer;
		codPro: integer;
		cant: integer;
		precio: real;
	end;
	
	producto = record
		codPro: integer;
		cant: integer;
		montoTotal: real;
	end;

	arbol = ^nodo;
	nodo = record
		dato: producto;
		hi: arbol;
		hd: arbol;
	end;
	
procedure leerVenta(var r:venta);
begin
	readln(r.codVen);
	if(r.codVen <> -1) then begin
		readln(r.codPro);
		readln(r.cant);
		readln(r.precio);
	end;
end;	
	
procedure agregarVenta(var a:arbol; r:venta);
begin
	if (a = nil ) then begin
		new(a);
		a^.dato.codPro:= r.codPro;
		a^.dato.cant:= r.cant;
		a^.dato.montoTotal:= (r.cant* r.precio);
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else
		if(a^.dato.codPro = r.codPro) then begin
			a^.dato.cant:= a^.dato.cant + r.cant;
			a^.dato.montoTotal:= a^.dato.montoTotal + (r.cant * r.precio);
		end
		else
			if(a^.dato.codPro < r.codPro)then
				agregarVenta(a^.hi,r) 
			else
				agregarVenta(a^.hd,r)	
end;	
	
procedure cargarArbol(var a:arbol);
var
	r:venta;
begin
	leerVenta(r);
	while (r.codVen <> -1) do begin
		agregarVenta(a,r);
		leerVenta(r);
	end;
end;		
	
procedure imprimir(a: arbol);
begin
	if(a <> nil) then begin
		imprimir(a^.hi);
		writeln(a^.dato.codPro);
		writeln(a^.dato.cant);
		writeln(a^.dato.montoTotal);
		imprimir(a^.hd);
	end;
end;

procedure codMayorVendidas(a :arbol);
	
	procedure buscarMayorVentas(a: arbol;var maxCant: integer;var maxCod: integer);
	begin
		if(a <> nil) then begin
			buscarMayorVentas(a^.hi,maxCant,maxCod);
			if(a^.dato.cant > maxCant)then begin
				maxCant:= a^.dato.cant;
				maxCod:= a^.dato.codPro;
			end;
			buscarMayorVentas(a^.hd,maxCant,maxCod);
		end;
	end;

var
	maxCant, maxCod: integer;
begin
	maxCant := -1;
	buscarMayorVentas(a,maxCant,maxCod);
	writeln(maxCod);
end;

procedure informarMenores(a: arbol);

	procedure cantidadMenores(a :arbol; x: integer; var c: integer);
	begin
		if(a <> nil) then begin
			if (a^.dato.codPro >= x) then
				cantidadMenores(a^.hi,x,c)
			else
				c:= c + 1;
				cantidadMenores(a^.hi,x,c);
		end	
	end;

var
	c,x: integer;
begin
	readln(x);
	c:= 0;
	cantidadMenores(a,x,c);
	write(c);
end;

function sumar(a:arbol; x,y: integer):real;
begin
	if(a = nil) then
		sumar:=0
	else begin
		if(x < a^.dato.codPro) then
			if(y > a^.dato.codPro) then
				sumar:= a^.dato.montoTotal + sumar(a^.hd,x,y) + sumar(a^.hi,x,y)
			else
				sumar(a^.hi,x,y)	
		else
			sumar(a^.hd,x,y);
	end;			
end;


var 
	a: arbol;
	x,y:integer;
BEGIN
	a:= nil;
	cargarArbol(a);	
	if(a<> nil )then begin
		imprimir(a);
		codMayorVendidas(a);
		informarMenores(a);
		readln(x);
		readln(y);
		writeln(sumar(a,x,y))
	end
	else 
		writeln('.')
END.


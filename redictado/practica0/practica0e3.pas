{
3.- Implementar un programa que procese las ventas de un supermercado. El supermercado
dispone de una tabla con los precios y stocks de los 1000 productos que tiene a la venta.
a) Implementar un módulo que retorne, en una estructura de datos adecuada, los tickets de
las ventas. De cada venta se lee el código de venta y los productos vendidos. Las ventas
finalizan con el código de venta -1. De cada producto se lee código y cantidad de unidades
solicitadas. Para cada venta, la lectura de los productos a vender finaliza con cantidad de
unidades vendidas igual a 0. El ticket debe contener:
- Código de venta
- Detalle (código de producto, cantidad y precio unitario) de los productos que se pudieron
vender. En caso de no haber stock suficiente, se venderá la máxima cantidad posible.
- Monto total de la venta.
c) Implementar un módulo que reciba la estructura generada en el inciso a) y un código de
producto y retorne la cantidad de unidades vendidas de ese código de producto.   
   
}


program practica0e3;

const
	dimf = 1000;

type
	
	prodStock = record
		codS: 1..dimf;
		stockS: integer;
		precioS: real;
	end;
	
	vector = array [1..dimf] of prodStock;
	
	productos = record
        codP: 1..dimf;
        cantP: integer;
        precioP: real;
    end;
    
    listaP = ^nodoP;
    nodoP = record
        data: productos;
        sig: listaP;
    end;
    
    tickets = record
        codigo: integer;
        detalle: listaP;
        total: real;
    end;
    
    lista = ^nodo;
    nodo = record
        dato: tickets;
        sig: lista;
    end;

var
	l: lista;
	v: vector;
	x: 1..dimf;
BEGIN
	l:= nil;
	armarVector(v);
	armarLista(l,v);
	readln(x);
	writeln(cantProductos(l,x));
END.


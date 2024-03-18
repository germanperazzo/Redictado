{
   1.- Implementar un programa que invoque a los siguientes módulos.
a. Un módulo recursivo que permita leer una secuencia de caracteres terminada en punto, los
almacene en un vector con dimensión física igual a 10 y retorne el vector.
b. Un módulo que reciba el vector generado en a) e imprima el contenido del vector.
c. Un módulo recursivo que reciba el vector generado en a) e imprima el contenido del vector.
d. Un módulo recursivo que permita leer una secuencia de caracteres terminada en punto y
retorne la cantidad de caracteres leídos. El programa debe informar el valor retornado.
e. Un módulo recursivo que permita leer una secuencia de caracteres terminada en punto y
retorne una lista con los caracteres leídos.
f. Un módulo recursivo que reciba la lista generada en e) e imprima los valores de la lista en el
mismo orden que están almacenados.
g. Implemente un módulo recursivo que reciba la lista generada en e) e imprima los valores de
la lista en orden inverso al que están almacenados.
   
}


program practica02e1;

const 
	dimF = 10;
type
	vector = array [1..dimF] of char;
    lista = ^nodo;
    nodo = record
              dato: char;
              sig: lista;
	end;


procedure CargarVectorRecursivo (var v: vector; var dimL: integer);
var caracter: char;
begin
	readln(caracter);  
    if (caracter <> '.' ) and (dimL < dimF) then begin
		dimL:= dimL + 1;
        v[dimL]:= caracter;
        CargarVectorRecursivo (v, dimL);
	end;
end;

procedure imprimirVector(v: vector; diml:integer);
var
	i:integer;
begin
	for i:= 1 to diml do begin
		write(v[i]);
	end;
end;

procedure imprimirVectorRecursivo(v: vector; diml:integer);
begin
	if(diml > 0) then begin
		imprimirVectorRecursivo(v,diml-1);
		write(v[diml]);
	end;
end;

function contarCaracteres():integer;
var
	x: char;
begin
	readln(x);
	if(x <> '.') then begin
		contarCaracteres:= contarCaracteres() + 1;
	end 
	else
		contarCaracteres:= 0;
end;

procedure cargarlista(var l:lista);
var
	x: char;
	nue: lista;
begin
	readln(x);
	if(x <> '.') then begin
		new(nue);
		nue^.dato:= x;
		nue^.sig:= l;
		l:=nue;
		cargarlista(l);
	end
	else l:= nil;
end;

procedure ImprimirListaMismoOrden (l: lista);
begin
	if (l<> nil) then begin
		ImprimirListaMismoOrden (l^.sig);
		write (' ', l^.dato);
	end;
end;

procedure ImprimirListainversa (l: lista);
begin
	if (l<> nil) then begin
		write (' ', l^.dato);
		ImprimirListainversa (l^.sig);
	end;
end;

var 
	v: vector;
	diml: integer;
	l: lista;

BEGIN
	l:= nil;
	diml:=0;
	CargarVectorRecursivo (v, dimL);
	imprimirVector(v, diml);
	imprimirVectorRecursivo(v,diml);
	writeln(contarCaracteres());
	cargarlista(l);
	ImprimirListaMismoOrden(l);
	ImprimirListainversa(l);
END.


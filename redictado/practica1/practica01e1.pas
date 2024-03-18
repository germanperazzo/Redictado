{
  1.- Se desea procesar la información de las ventas de productos de un comercio (como máximo
50).
Implementar un programa que invoque los siguientes módulos:
a. Un módulo que retorne la información de las ventas en un vector. De cada venta se conoce
el día de la venta, código del producto (entre 1 y 15) y cantidad vendida (como máximo 99
unidades). El código debe generarse automáticamente (random) y la cantidad se debe leer. El
ingreso de las ventas finaliza con el día de venta 0 (no se procesa).
b. Un módulo que muestre el contenido del vector resultante del punto a).
c. Un módulo que ordene el vector de ventas por código.
d. Un módulo que muestre el contenido del vector resultante del punto c).
e. Un módulo que elimine, del vector ordenado, las ventas con código de producto entre dos
valores que se ingresan como parámetros.
f. Un módulo que muestre el contenido del vector resultante del punto e).
g. Un módulo que retorne la información (ordenada por código de producto de menor a
mayor) de cada código par de producto junto a la cantidad total de productos vendidos.
h. Un módulo que muestre la información obtenida en el punto g). 
   
   
}


program practica01e1;
const

	dimf = 50;

type	
	rango = 0..dimf;
	
	ventas = record
		dia: 0..31;
		cod: 1..15;
		cant: 1..99;
	end;

	vector = array [1..dimf] of ventas;

	lista = ^nodo;
	 nodo = record
	          dato: ventas;
	          sig: lista;
	        end;
	
procedure leerVenta(var r:ventas);
begin
	Randomize;
	readln(r.dia);
	if(r.dia <> 0) then begin
		r.cod:= random(14) + 1;;
		readln(r.cant);
	end;
end;

procedure armarVector(var v:vector; var diml:rango);
var
	r:ventas;
begin
	diml:= 0;
	leerVenta(r);
	while(r.dia <> 0) and (diml < dimf)do begin
		diml:= diml + 1;
		v[diml]:= r;
		leerVenta(r);
	end;
end;

procedure imprimirVector(v:vector; diml:rango);
var
	i: integer;
begin
	for i:=1 to diml do begin
		writeln(v[i].cod);
		writeln(v[i].dia);
		writeln(v[i].cant);
	end;
end;

procedure ordenarVector(var v:vector; diml:rango);
var
	i,j,pos: integer;
	r: ventas;
begin
	for i:=1 to diml-1 do begin
		pos:= i;
		for j:= i+1 to diml do
			if(v[j].cod < v[pos].cod ) then pos:=j;
		r:= v[pos];
		v[pos]:= v[i];
		v[i]:= r;
	end;
end;

procedure Eliminar (var v: vector; var dimL: rango; valorInferior, valorSuperior: integer);

  function BuscarPosicion (v: vector; dimL: rango; elemABuscar: integer): rango;
  var pos: rango;
  begin
    pos:= 1;
    while (pos <= dimL) and (elemABuscar > v[pos].cod) do
       pos:= pos + 1;
    if (pos > dimL) then BuscarPosicion:= 0
                    else BuscarPosicion:= pos;
  end;
  
  function BuscarPosicionDesde (v: vector; dimL, pos : integer; elemABuscar: integer): rango;
  begin
    while (pos <= dimL) and (elemABuscar >= v[pos].cod) do
       pos:= pos + 1;
    if (pos > dimL) then BuscarPosicionDesde:= dimL
                    else BuscarPosicionDesde:= pos - 1;
  end;

var posInferior, posSuperior, i,diferencia: rango; 
Begin
  posInferior:= BuscarPosicion (v, dimL, valorInferior);
  if (posInferior <> 0)
  then begin
         posSuperior:= BuscarPosicionDesde (v, dimL, posInferior, valorSuperior);
         
         diferencia := posInferior - posSuperior;
         
         for i:= posInferior  to (diml - diferencia) do begin
			v[i]:= v[i + diferencia];
         end;
         diml:= diml - diferencia;
       end;
end;

procedure GenerarLista (v: vector; dimL: rango; var L: lista);

	procedure AgregarAdelante (var L: lista; elem: ventas);
	var
		nue:lista;
	begin
		new(nue);
		nue^.dato:= elem;
		nue^.sig:=L;
		L:= nue;
	end;
  
	function Cumple (num: integer): boolean;
	begin
		Cumple:= (num mod 2 = 0)
	end;
  
var i: rango; 
begin
  L:= nil;
  for i:= dimL downto 1 do 
    if Cumple (v[i].cod) then AgregarAdelante (L, v[i]);
end; 

procedure ImprimirLista (L: lista);
begin
	while( L <> nil) do begin
		writeln(L^.dato.cod);
		writeln(L^.dato.dia);
		writeln(L^.dato.cant);
		L:= L^.sig;
	end;
end;

var 
	v: vector;
	diml: rango;
	x,y : integer;
	L: lista;
BEGIN
	armarVector(v,diml);
	imprimirVector(v,diml);
	ordenarVector(v,diml);
	imprimirVector(v,diml);
	readln(x);
	readln(y);
	Eliminar(v,diml,x,y);
	imprimirVector(v,diml);
	GenerarLista(v,diml,L);
	ImprimirLista(L);
END.


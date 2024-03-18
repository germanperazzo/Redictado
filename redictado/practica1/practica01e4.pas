{

4.- Una librería requiere el procesamiento de la información de sus productos. De cada
producto se conoce el código del producto, código de rubro (del 1 al 8) y precio.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Lea los datos de los productos y los almacene ordenados por código de producto y
agrupados por rubro, en una estructura de datos adecuada. El ingreso de los productos finaliza
cuando se lee el precio 0.
b. Una vez almacenados, muestre los códigos de los productos pertenecientes a cada rubro.
c. Genere un vector (de a lo sumo 30 elementos) con los productos del rubro 3. Considerar que
puede haber más o menos de 30 productos del rubro 3. Si la cantidad de productos del rubro 3
es mayor a 30, almacenar los primeros 30 que están en la lista e ignore el resto.
d. Ordene, por precio, los elementos del vector generado en c) utilizando alguno de los dos
métodos vistos en la teoría.
e. Muestre los precios del vector resultante del punto d).
f. Calcule el promedio de los precios del vector resultante del punto d).
   
   
}


program practica01e4;
const
	dimf = 30;
type
	codRubro = 1..8;
	rango = 0..dimf;
	
	productoAguardar = record
		cod: integer;
		precio: real;
	end; 
	
	producto = record
		rubro: codRubro;
		ag: productoAGuardar;
	end;

	lista = ^nodo;
	nodo = record
		dato: productoAGuardar;
		sig: lista;
	end;

	vector = array [codRubro] of lista;
	
	vector3 = array [rango] of productoAGuardar;

procedure iniciarVector(var v: vector);
var
	i: codRubro;
begin
	for i:= 1 to 8 do begin
		v[i]:= nil;
	end;	
end;

procedure leerProducto(var r: producto);
begin
	readln(r.ag.precio);
	if(r.ag.precio <> 0) then begin
		readln(r.rubro);
		readln(r.ag.cod);
	end;
end;
	
procedure insertarOrdenado(var l: lista; r: productoAGuardar);
var
	act,ant,nue: lista;
begin
	new(nue); nue^.dato:= r; nue^.sig:= nil;
	
	if(l = nil) then l:= nue
	else begin
		act:= l;
		ant:= l;
		while (act <> nil) and (act^.dato.cod < nue^.dato.cod) do begin
			ant:= act;
			act:= act^.sig;
		end;
	end;
	if(act = l) then begin
		nue^.sig:= l;
		l:= nue;
	end
	else begin
		ant^.sig:= nue;
		nue^.sig:= act;
	end;
end;
	
procedure cargarProductos(var v: vector);
var
	r: producto;
begin
	leerProducto(r);
	while(r.ag.precio <> 0) do begin
		insertarOrdenado(v[r.rubro],r.ag);
		leerProducto(r);
	end;
end;	

procedure imprimirVector(v: vector);
var
	i: integer;
begin
	for i:= 1 to 8 do begin
		writeln(i);
		while(v[i] <> nil) do begin
			writeln(v[i]^.dato.cod);
			writeln(v[i]^.dato.precio);
			v[i]:=v[i]^.sig
		end;
	end;
end;

procedure cargarVectorRubro3 (v: vector;var diml: rango; var v3: vector3);
begin
	diml:= 0;
	while(v[3] <> nil) and (diml < dimf) do begin
		diml:= diml + 1;
		v3[diml]:= v[3]^.dato;
		v[3]:=v[3]^.sig;
	end;
end;

procedure ordenarVector(var v: vector3; diml: rango);
var
	i,j,pos: rango;
	r: productoAGuardar;
begin
	for i:= 1 to diml - 1 do begin
		pos:=i;
		for j:= i + 1 to diml do begin
			if(v[j].precio < v[pos].precio) then pos:= j;
		end;
		r:= v[pos];
		v[pos]:= v[i];
		v[i]:= r;
	end; 
end;

procedure imprimirVector3(v: vector3; diml: rango);
var
	i:rango;
begin
	for i:= 1  to diml do begin
		writeln(v[i].cod);
		writeln(v[i].precio);
	end;
end;	

function promedio(v: vector3; diml: rango):real;
var
	i: rango;
	total: real;
begin
	total:= 0;
	for i:= 1 to diml do begin
		total:= total + v[i].precio;
	end;
	promedio:= total/diml;
end;

var 
	v: vector;
	v3: vector3;
	diml: rango;
BEGIN
	iniciarVector(v);
	cargarProductos(v);
	imprimirVector(v);
	cargarVectorRubro3(v,diml,v3);
	ordenarVector(v3,diml);
	imprimirVector3(v3,diml);
	writeln(promedio(v3,diml));
END.


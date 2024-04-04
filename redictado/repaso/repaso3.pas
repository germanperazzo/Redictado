{
3. Un supermercado requiere el procesamiento de sus productos. De cada producto se
conoce código, rubro (1..10), stock y precio unitario. Se pide:
a) Generar una estructura adecuada que permita agrupar los productos por rubro. A su
vez, para cada rubro, se requiere que la búsqueda de un producto por código sea lo
más eficiente posible. La lectura finaliza con el código de producto igual a -1.
b) Implementar un módulo que reciba la estructura generada en a), un rubro y un código
de producto y retorne si dicho código existe o no para ese rubro.
c) Implementar un módulo que reciba la estructura generada en a), y retorne, para cada
rubro, el código y stock del producto con mayor código.
d) Implementar un módulo que reciba la estructura generada en a), dos códigos y
retorne, para cada rubro, la cantidad de productos con códigos entre los dos valores
ingresados.  
   
}


program repaso3;
type
	rubro = 1..10;
	
	productoAGuardar = record
		cod: integer;
		precio: real;
		stock: integer;
	end;
	
	producto = record
		rub: rubro;
		ag: productoAGuardar;
	end;

	arbol = ^nodoA;
	nodoA = record
		dato: productoAGuardar;
		hi,hd: arbol;
	end;

	vector = array [rubro] of arbol;
	
	vector2 = array[rubro] of productoAGuardar;
	
	vector3 = array[rubro] of integer;

procedure iniciarVectorArboles(var v:vector);
var
	i: integer;
begin
	for i:= 1 to 10 do begin
		v[i]:= nil;
	end;
end;

procedure leerProducto(var r:producto);
begin
	readln(r.ag.cod);
	if (r.ag.cod <> -1) then begin
		readln(r.rub);
		readln(r.ag.precio);
		readln(r.ag.stock);
	end;
end;

procedure agregarProducto(var a:arbol; r:productoAGuardar);
begin
	if (a = nil) then begin
		new(a);
		a^.dato:= r;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else
		if(r.cod = a^.dato.cod) then 
			a^.dato.stock:= a^.dato.stock + r.stock
		else
			if(r.cod < a^.dato.cod)then 
				agregarProducto(a^.hi,r)
			else
				agregarProducto(a^.hd,r)	
end;

procedure cargarVectorArbol(var v:vector);
var
	r: producto;	
begin
	iniciarVectorArboles(v);
	leerProducto(r);	
	while(r.ag.cod <> -1) do begin
		agregarProducto(v[r.rub],r.ag);
		leerProducto(r);
	end;
end;

function buscar(a:arbol; y:integer):boolean;
begin
	if(a = nil) then
		buscar:= false
	else
		if(a^.dato.cod = y) then
			buscar:= true
		else
			if(y < a^.dato.cod) then
				buscar:= buscar(a^.hi, y)
			else
				buscar:= buscar(a^.hd,y)			
end;
procedure confirmar(v:vector; var esta:boolean);
var
	x,y:integer;
begin
	readln(x);
	readln(y);
	esta:= false;
	if(v[x] = nil) then 
		esta:= false
	else
		esta:=buscar(v[x],y);
end;

function maximoNodo(a:arbol):arbol;
begin
	if(a = nil) then
		maximoNodo:= nil
	else
		if(a^.hd = nil)then
			maximoNodo:= a
		else
			maximoNodo:= maximoNodo(a^.hd);	
end;

procedure mayorProductoPorRubro(v:vector;var v2:vector2);
var 
	i:integer;
	aux: arbol;
begin
	for i:= 1 to 10 do begin
		if(v[i] <> nil)then
			aux:= maximoNodo(v[i]);
			v2[i]:= aux^.dato;
	end;
end;

procedure iniciarVector3(var v3:vector3);
var
	i:integer;
begin
	for i:=1 to 10 do begin
		v3[i]:= 0;
	end;
end;	

function contar(a:arbol; x,y:integer):integer;
begin
end;

procedure generarVector3(v:vector; var v3:vector3);
var
	i,x,y:integer;
begin
	iniciarVector3(v3);
	for i:= 1 to 10 do begin
		if(v[i] <> nil)then
			readln(x);
			readln(y);
			v3[i]:= contar(v[i],x,y);
	end;
end;

var 
	v: vector;
	esta: boolean;
	v2: vector2;
	v3: vector3;
BEGIN
	cargarVectorArbol(v);
	confirmar(v,esta);
	mayorProductoPorRubro(v,v2);
	generarVector3(v,v3);
END.


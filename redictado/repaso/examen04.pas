program examen04;
const
	dimf = 12; 
type
	rangoMes = 0..dimf;
	
	compra = record
		cod: integer;
		mes: rangoMes;
		monto: real;
	end;
	
	vector = array [1..dimf] of real;

	arbol = ^nodo;
	nodo = record
		cod: integer;
		vec: vector;
		hi,hd: arbol;
	end;
	

procedure leerCompra(var r:compra);
begin
	readln(r.cod);
	if(r.cod <> 0 ) then begin
		readln(r.monto);
		readln(r.mes);
	end;
end;

procedure iniciarVector(var v:vector);
var
	i: rangoMes;
begin
	for i:=1 to dimf do begin
		v[i]:= 0;
	end;
end;

procedure agregarArbol(var a:arbol; r:compra);
begin
	if(a = nil) then begin
		new(a);
		a^.cod:= r.cod;
		iniciarVector(a^.vec);
		a^.vec[r.mes]:= a^.vec[r.mes] + r.monto;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else
		if(r.cod = a^.cod) then
			a^.vec[r.mes]:= a^.vec[r.mes] + r.monto
		else
			if(r.cod < a^.cod)then
				agregarArbol(a^.hi,r)
			else
				agregarArbol(a^.hd,r)	
end;	
	
	
procedure cargarArbol(var a :arbol);
var
	r:compra;
begin
	leerCompra(r);
	while(r.cod <> 0) do begin
		agregarArbol(a,r);	
		leerCompra(r);
	end;
end;

function buscar(a:arbol; x:integer):arbol;
begin
	if(a = nil) then
		buscar:= nil
	else
		if(a^.cod = x) then
			buscar:= a
		else
			if(x < a^.cod)then
				buscar:= buscar(a^.hi,x)
			else
				buscar:= buscar(a^.hd,x)			
end;
	
function max(v: vector):rangoMes;
var
	maxMes,i: rangoMes;
	maxMonto: real;
begin
	maxMes:= 0;
	maxMonto:= -1;
	for i:= 1 to dimf do begin
		if(maxMonto < v[i])then begin
			maxMonto:= v[i];
			maxMes:= i;
		end;	
	end;
	max:= maxMes;
end;		
	
procedure mesMax(a:arbol;var x:rangoMes);	
var
	y:integer;
	v:arbol;
begin
	readln(y);
	v:= buscar(a,y);

	if(v <> nil) then
		x:= max(v^.vec)
	else
		x:= 0;	
end;	
	
procedure contar(a:arbol; x:rangoMes; y:integer);
begin
	if(a <> nil) then
		contar(a^.hi,x,y);
		if(a^.vec[x] = 0) then
			y:= y + 1; 
		contar(a^.hd,x,y);
end;	
	
procedure mesNoGastado(a:arbol;var y: integer);	
var 
	x:rangoMes;
begin
	y:= 0;
	readln(x);
	contar(a,x,y);
end;	



var 
	a:arbol;
	x:rangoMes;
	y: integer;
BEGIN
	cargarArbol(a);
	if(a = nil)then
		writeln('arbol vacio')
	else begin
		mesMax(a,x);
		mesNoGastado(a,y)
	end;	
END.


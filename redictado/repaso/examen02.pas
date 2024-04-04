program examen02;
const
	dimf = 12;	
type
	
	d = 1..31;
	m = 1..dimf;
	
	compra = record
		cod: integer;
		cliente: integer;
		dia: d;
		mes: m;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato: compra;
		hi,hd: arbol;
	end;
	
	lista = ^nodoL;
	nodoL = record
		dia: d;
		mes: m;
		cod: integer;
		sig: lista;
	end;
	
	meses = record
		mes: m;
		cant: integer;
	end;
 	
	vector = array [m] of meses;
	
procedure leerCompra(var r:compra);
begin
	r.cliente:= Random(100);
	if(r.cliente <> 0) then begin
		r.dia:= Random(31) + 1;
		r.mes:= Random(12) + 1;
		r.cod:= Random(20000) + 1;
	end;
end;	
	
procedure iniciarVector(var v:vector);
var 
	i: integer;
begin
	for i:=1 to 12 do begin
		v[i].mes:= i;
		v[i].cant:= 0; 
	end;
end;	

procedure agregarArbol(var a:arbol; r:compra);
begin
	if(a = nil)then begin
		new(a);
		a^.dato:= r;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else
		if(r.cliente < a^.dato.cliente) then
			agregarArbol(a^.hi,r)
		else
			agregarArbol(a^.hd,r)	
end;

	
	
procedure generarEstructuras(var a:arbol;var  v:vector);
var
	r: compra;
begin
	iniciarVector(v);
	leerCompra(r);
	while(r.cliente <> 0) do begin
		agregarArbol(a,r);
		v[r.mes].cant:= v[r.mes].cant + 1;
	end;
end;		
	
procedure agregarLista(var l:lista; r:compra);
var
	nue: lista;
begin
	new(nue);
	nue^.mes:= r.mes;
	nue^.cod:= r.cod;
	nue^.dia:= r.dia;
	nue^.sig:= l;
	l:= nue;
end;		
	
procedure buscar(a:arbol; x: integer; var l:lista);
begin
	if(a = nil) then
		l:= nil
	else
		if(a^.dato.cliente = x) then begin
			agregarLista(l,a^.dato);
			buscar(a^.hi,x,l);
			buscar(a^.hd,x,l);
		end	
		else
			if(x < a^.dato.cliente) then
				buscar(a^.hi,x,l)
			else
				buscar(a^.hd,x,l)			
end; 	
	
procedure contar(a:arbol;var l:lista);
var
	y:integer;
begin
	readln(y);
	buscar(a,y,l);
end;	
	
procedure ordenar(var v:vector);
var
	x: meses;
	i,j,pos: m;
begin
	for i:= 1 to dimf-1 do begin
		pos:= i;
		for j:= i+1 to dimf do begin
			if(v[j].cant > v[pos].cant) then
				pos:= j;
					
			x:= v[pos];
			v[pos]:= v[i];
			v[i]:= x;
		end;
	end;		
end;		
	
var 
	a: arbol;
	v: vector;
	l: lista;
BEGIN
	randomize;
	generarEstructuras(a,v);
	if(a = nil) then
		write('estructuras vacias')
	else begin
		l:= nil;
		contar(a,l);
		ordenar(v);
	end;	
END.


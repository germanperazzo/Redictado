program examen01;
type
	prestamo = record
		num: integer;
		isbn: integer;
		socio: integer;
	end;
	
	
	arbolA = ^nodoA;
	nodoA = record
		isbn: integer;
		num: integer;
		socio: integer;
		hi,hd: arbolA;
	end;
		
		
	listaB = ^nodoLB;
	nodoLB = record
		socio: integer;
		cant: integer;
		sig: listaB;
	end;
	
procedure leerPrestamo(var r:prestamo);
begin
	readln(r.socio);
	if(r.socio <> 0) then begin
		readln(r.isbn);
		readln(r.num);
	end;
end;		
		
procedure agregarArbol(var a:arbolA; r:prestamo);
begin
	if (a = nil) then begin
		new(a);
		a^.isbn := r.isbn;
		a^.num:= r.num;
		a^.socio:= r.socio;			
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else
		if(r.isbn < a^.isbn) then
			agregarArbol(a^.hi,r)
		else
			agregarArbol(a^.hd,r)	
end;		
		
procedure agregarLista(var l:listaB; socio,cant:integer );
var
	nue: listaB;
begin
	new(nue);
	nue^.socio:= socio;
	nue^.cant:= cant;
	nue^.sig:= l;
	l:= nue;
end;		
		
procedure cargar(var a:arbolA; var l:listaB);
var
	r:prestamo;
	cant: integer;
	act: integer;
begin
	leerPrestamo(r);
	while(r.socio <> 0)do begin
		cant:= 0;
		act:= r.socio;
		while (act = r.socio) and (r.socio <> 0)do begin
			agregarArbol(a,r);
			leerPrestamo(r);
		end;
		agregarLista(l,act,cant);
	end;
end;		
		
function contarISBN(a:arbolA; y:integer):integer;		
begin
	if(a = nil)then
		contarISBN:= 0
	else
		if(a^.isbn = y) then
			contarISBN:= 1 + contarISBN(a^.hi,y) + contarISBN(a^.hd,y)
		else
			if(y < a^.isbn) then
				contarISBN:=contarISBN(a^.hi,y)
			else
				contarISBN:=contarISBN(a^.hi,y)	
				
end;
		
procedure contar(a:arbolA; var x:integer);
var
	y: integer;
begin
	readln(y);
	x := contarISBN(a,y);
end;

function contarRecursivo(l:listaB; y:integer):integer;
begin
	if (l = nil)then 
		contarRecursivo:= 0
	else
		if (y < l^.cant)then
			contarRecursivo:= 1 + contarRecursivo(l^.sig,y)
		else
			contarRecursivo:= 0 + contarRecursivo(l^.sig,y)		
end;

procedure contarLista(l:listaB;var x:integer);
var
	y: integer;
begin
	readln(y);
	x:= contarRecursivo(l,y);
end;

var 
	a: arbolA;
	l: listaB;
	x:integer;
	y: integer;
BEGIN
	a:= nil;
	l:= nil;
	cargar(a,l);
	if(a = nil) then 
		write('arbol vacio')
	else	
		contar(a,x);
	if(l = nil) then
		writeln('lista vacia')
	else
		contarLista(l,y);		
END.


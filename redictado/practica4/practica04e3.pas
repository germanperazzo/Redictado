{
  Una facultad nos ha encargado procesar la información de sus alumnos de la carrera XXX.
Esta carrera tiene 30 materias. Implementar un programa con:
a. Un módulo que lea la información de los finales rendidos por los alumnos y los
almacene en dos estructuras de datos.
i. Una estructura que para cada alumno se almacenen sólo código y nota de las
materias aprobadas (4 a 10). De cada final rendido se lee el código del alumno, el
código de materia y la nota (valor entre 1 y 10). La lectura de los finales finaliza con
nota -1. La estructura debe ser eficiente para buscar por código de alumno.
ii. Otra estructura que almacene para cada materia, su código y todos los finales
rendidos en esa materia (código de alumno y nota).
b. Un módulo que reciba la estructura generada en i. y un código de alumno y retorne los
códigos y promedios de los alumnos cuyos códigos sean mayor al ingresado.
c. Un módulo que reciba la estructura generada en i., dos códigos de alumnos y un valor
entero, y retorne la cantidad de alumnos con cantidad de finales aprobados igual al
valor ingresado para aquellos alumnos cuyos códigos están comprendidos entre los
dos códigos de alumnos ingresados.
   
}


program practica04e3;
const
	dimf = 30;
type
	rango = 0..dimf;
	
	finalRendido = record
		nota: integer;
		legajo: integer;
		cod: rango;
	end;
	
	
	vector = array [1..dimf] of integer; 
	
	alumno = record
		legajo: integer;
		finales: vector;
	end;

	arbol = ^nodo;
	nodo = record
		dato: alumno;
		hi: arbol;
		hd: arbol;
	end;
	
	lista = ^nodoL;
	nodoL = record
		legajo: integer;
		nota: integer; 
		sig:lista;
	end;
	
	vector2 = array [1..dimf] of lista;
	
	listaP = ^nodoP;
	nodoP = record
		prom: real;
		legajo: integer;
		sig: listaP;
	end;	

procedure leerFinales(var r:finalRendido);
begin
	readln(r.nota);
	if(r.nota <> -1) then begin
		readln(r.legajo);
		readln(r.cod);
	end;
end;

procedure iniciarVector(var v: vector);
var
	i: integer;
begin
	for i:=1 to dimf do begin
		v[i]:= 0;
	end;
end;

procedure agregarArbol(var a: arbol; r: finalRendido);
begin
	if (a = nil)then begin
		new(a);
		iniciarVector(a^.dato.finales);
		a^.dato.legajo:= r.legajo;
		a^.dato.finales[r.cod]:= r.nota;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else
		if(a^.dato.legajo = r.legajo) then
			a^.dato.finales[r.cod]:= r.nota
		else
			if(a^.dato.legajo < r.legajo) then
				agregarArbol(a^.hi,r)
			else
				agregarArbol(a^.hd,r)		
end;

procedure iniciarVector2(var v :vector2);
var
	i: integer;
begin
	for i:= 1 to dimf do begin
		v[i]:= nil;
	end;
end;

procedure agregarLista(var l: lista; r: finalRendido);
var
	nue: lista;
begin
	new(nue);
	nue^.legajo:= r.legajo;
	nue^.nota:= r.nota;
	nue^.sig:= l;
	l:= nue;
end;

procedure arbarEstructuras(var a:arbol; var v:vector2);
var
	r:finalRendido;
begin
	leerFinales(r);
	while (r.nota <> -1) do begin
		agregarArbol(a,r);
		iniciarVector2(v);
		agregarLista(v[r.cod],r);
		leerFinales(r);	
	end;
end;		
	
function promedio(v: vector):real;
var
	i,c,n: integer;
begin
	n:= 0;
	c:= 0;
	for i:= 1 to dimf do begin
		if (v[i] >= 4) then begin
			n:= n + v[i];
			c:= c + 1; 
		end;
	end;
	promedio:= n/c;
end;	

procedure agregarListaP(var l: listaP; r: integer;x: real);
var
	nue: listaP;
begin
	new(nue);
	nue^.legajo:= r;
	nue^.prom:= x;
	nue^.sig:= l;
	l:= nue;
end;

procedure promediosMayores(a: arbol; x:integer; var l:listaP );
begin
	if (a <> nil) then begin
		if(a^.dato.legajo > x)	then begin
			agregarListaP(l, a^.dato.legajo, promedio(a^.dato.finales));
			promediosMayores(a^.hi,x,l);
			promediosMayores(a^.hd,x,l);
		end
		else
			promediosMayores(a^.hd,x,l)
	end;			
end;

function contarFinales(v :vector):integer;
var 
	c,i:integer;
begin
	c:= 0;
	for i:= 1 to dimf do begin
		if (v[i] >= 4) then 
			c:= c + 1;
	end;
	contarFinales:= c;
end;

function buscar(a: arbol; x: integer):integer;
begin
	if(a = nil) then 
		buscar:= -1
	else
		if(a^.dato.legajo = x) then
			buscar:= contarFinales(a^.dato.finales)
		else
			if(a^.dato.legajo > x) then
				buscar(a^.hi,x)
			else
				buscar(a^.hd,x) 	
end;

function mismoFinales(v: vector; x: integer):integer;
var
	i,c: integer;
begin
	c:= 0;
	for i:= 1 to dimf do begin
		if (v[i] >= 4) then begin
			c:= c + 1;
	end;
	if(c = x) then
		mismoFinales:= 1
	else
		mismoFinales:= 0;
	end;			
end;

function sumar(a: arbol; x,y,z: integer):integer;
begin
	if(a = nil) then
		sumar:=0
	else begin
		if(x < a^.dato.legajo) then
			if(y > a^.dato.legajo) then
				sumar:= mismoFinales(a^.dato.finales,z) + sumar(a^.hd,x,y,z) + sumar(a^.hi,x,y,z)
			else
				sumar(a^.hi,x,y,z)	
		else
			sumar(a^.hd,x,y,z);
	end;			
end;
	
procedure moduloD (a:arbol);
var
	w,x,y,z:integer;
begin
	readln(w);
	z:=buscar(a,w);
	if( z <> -1)then begin
		readln(x);
		readln(y);
		writeln(sumar(a,x,y,z));
	end	
	else
		writeln('no existe pp')
end;

		
var 
	a: arbol;
	v: vector2;
	l: listaP;
	x: integer;
BEGIN
	arbarEstructuras(a,v);
	if(a = nil)then
		writeln('arbol vacio y vector vacio')
	else
		l:= nil;
		readln(x);
		promediosMayores(a,x,l);
		moduloD(a);	
END.


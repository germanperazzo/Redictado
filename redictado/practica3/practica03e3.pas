{

   3.Implementar un programa que contenga:
a. Un módulo que lea información de alumnos de Taller de Programación y los almacene en
una estructura de datos. De cada alumno se lee legajo, DNI, año de ingreso y los códigos y
notas de los finales rendidos. La estructura generada debe ser eficiente para la búsqueda por
número de legajo. La lectura de los alumnos finaliza con legajo 0 y para cada alumno el ingreso
de las materias finaliza con el código de materia -1.
b. Un módulo que reciba la estructura generada en a. y retorne los DNI y año de ingreso de
aquellos alumnos cuyo legajo sea inferior a un valor ingresado como parámetro.
c. Un módulo que reciba la estructura generada en a. y retorne el legajo más grande.
d. Un módulo que reciba la estructura generada en a. y retorne el DNI más grande.
e. Un módulo que reciba la estructura generada en a. y retorne la cantidad de alumnos con
legajo impar.
e. Un módulo que reciba la estructura generada en a. y retorne el legajo y el promedio del
alumno con mayor promedio.
f. Un módulo que reciba la estructura generada en a. y un valor entero. Este módulo debe
retornar los legajos y promedios de los alumnos cuyo promedio supera el valor ingresado.
   
}


program practica03e3;
type

	fin = record
		nota: real;
		cod: integer;
	end;
	
	lista = ^nodo;
	nodo = record
		dato: fin;
		sig: lista;
	end;
	
	alumno = record
		legajo: integer;
		dni: integer;
		ano: integer;
		finales: lista;
	end;
	
	arbol = ^nodoA;
	nodoA = record
		dato: alumno;
		hi: arbol;
		hd: arbol;
	end;

	alum = record
		dni: integer;
		ano: integer;
	end;

	listaA = ^nodoLA;
	nodoLA = record
		dato: alum;
		sig: listaA;
	end;

procedure leerFinal(var rf:fin);
begin
	readln(rf.cod);
	if (rf.cod <> -1) then readln(rf.nota);
end;

procedure agregarFinal(var l:lista; rf:fin);
var
	nue: lista;
begin
	new(nue);
	nue^.dato:= rf;
	nue^.sig:= l;
	l:= nue;
end;

procedure leerAlumno(var r:alumno);
var
	rf: fin;
begin
	readln(r.legajo);
	r.finales:= nil;
	if (r.legajo <> 0) then begin
		readln(r.dni);
		readln(r.ano);
		leerFinal(rf);
		while (rf.cod <> -1) do begin
			agregarFinal(r.finales,rf);
			leerFinal(rf);
		end;
	end;
end;	

procedure agregarAlumno(var a: arbol; r:alumno);
begin
	if (a = nil) then begin
		new(a);
		a^.dato:= r;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else
		if(r.legajo < a^.dato.legajo) then
			agregarAlumno(a^.hi,r)
		else
			agregarAlumno(a^.hd,r);	
end;

procedure cargarArbol(var a:arbol);
var
	r : alumno;
begin
	leerAlumno(r);
	while (r.legajo <> 0) do begin
		agregarAlumno(a,r);
		leerAlumno(r);
	end;
end;

procedure agregarL(var l: listaA; r:alumno);
var
	nue: listaA;
begin
	new(nue);
	nue^.dato.ano:= r.ano;
	nue^.dato.dni:= r.dni;
	nue^.sig:= l;
	l:= nue;
end;


procedure armarListaA(var a: arbol;var l: listaA; x: integer);
begin
	if (a <> nil) then begin
		armarListaA(a^.hi,l,x);
		if (a^.dato.legajo < x) then
			agregarL(l,a^.dato);
		armarListaA(a^.hd,l,x);
	end;
end;

function legajoMasGrande(a: arbol):integer;
begin
	if(a^.hd = nil) then
		legajoMasGrande:=a^.dato.legajo
	else
		legajoMasGrande(a^.hd);	
end;

procedure dniMasGrande(a: arbol; x:integer);
begin
	if(a <> nil) then begin
		dniMasGrande(a^.hi,x);
		if(a^.dato.dni > x) then
			x:= a^.dato.dni;
		dniMasGrande(a^.hd,x);
	end;	
end;

function legajoImpar(a: arbol):integer;
begin
	if (a = nil) then 
		legajoImpar:= 0
	else begin
		if ((a^.dato.legajo mod 2) = 1 ) then
			legajoImpar:= 1 + legajoImpar(a^.hi) + legajoImpar(a^.hd)
		else
			legajoImpar:= legajoImpar(a^.hi) + legajoImpar(a^.hd);	
	end;	
end;
var 
	a: arbol;
	l: listaA;
	x,y,w,z: integer;
BEGIN
	cargarArbol(a);
	if(a = nil)then 
		writeln('arbol vacio')
	else begin	
		l:=nil;
		readln(x);
		armarListaA(a,l,x);
		y:=legajoMasGrande(a);
		writeln(y);
		w:= -1;
		dniMasGrande(a,w);
		writeln(w);
		z:=legajoImpar(a);
		writeln(z);
	end;	
END.


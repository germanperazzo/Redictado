{1.- Implementar un programa que procese la información de los alumnos de la Facultad de
Informática.
a) Implementar un módulo que lea y retorne, en una estructura adecuada, la información de
todos los alumnos. De cada alumno se lee su apellido, número de alumno, año de ingreso,
cantidad de materias aprobadas (a lo sumo 36) y el código de materia junto con la nota
obtenida (sin contar los aplazos) en cada una de las materias aprobadas. La lectura finaliza
cuando se ingresa el número de alumno 11111, el cual debe procesarse.
b) Implementar un módulo que reciba la estructura generada en el inciso a) y retorne la
información con número de alumno y promedio de cada alumno.
c) Implementar un módulo que reciba la estructura generada en el inciso a) y retorne la
información con número de alumno y el código y nota de la materia con mayor nota de cada
alumno.
d) Analizar: ¿qué cambios requieren los puntos a y b, si no se sabe de antemano la cantidad de
materias aprobadas de cada alumno, y si además se desean registrar los aplazos? ¿cómo
puede diseñarse una solución modularizada que requiera la menor cantidad de cambios?
* }


program practica0e1;
const
	dimf = 36;
type
	
	materia = record
		cod: integer;
		nota: real;
	end;
	
	materias = array  [1..dimf] of materia;
	
	alumno = record
		apellido: string;
		num: integer;
		anio: integer;
		cantMaterias: 1..dimf;
		vec: materias;	
	end;
	
	lista = ^nodo;
	nodo = record
		alum: alumno;
		sig: lista;
	end;
	
	alumno2 = record
		num: integer;
		cod: integer;
		nota: real;
	end;
	
	lista2 = ^nodo2;
	nodo2 = record
		alum2: alumno2;
		sig: lista2;
	end;
	
procedure leerAlumno(var a: alumno);
var
	i: integer;
begin
	readln(a.num);
	if (a.num <> 11111) then begin
		readln(a.apellido);
		readln(a.anio);
		readln(a.cantMaterias);
		for i:= 1 to a.cantMaterias do begin
			readln(a.vec[i].cod);
			readln(a.vec[i].nota);
		end;
	end;
end;
	
procedure agregarAdelante(var l:lista ;a: alumno);
var
	nue: lista;
begin
	new(nue);
	nue^.alum := a;
	nue^.sig := l;
	l:= nue;
end;

procedure agregarAdelante2(var l2:lista2 ;a: alumno2);
var
	nue: lista2;
begin
	new(nue);
	nue^.alum2 := a;
	nue^.sig := l2;
	l2:= nue;
end;


procedure armarLista(var l:lista);
var
	a: alumno;
begin
	leerAlumno(a);
	while (a.num <> 11111) do begin
		agregarAdelante(l,a);
	end;
end;		

function prom(v: materias; x:integer):real;
var
	p:real;
	i:integer;
begin
	p:= 0;
	for i:=1 to x do begin
		p:= p + v[i].nota;
	end;
	prom:= (p/x);
end;

procedure leerLista(l:lista);
begin
	while(l<>nil) do begin
		writeln('El alumno ',l^.alum.apellido,' tiene un promedio de ', prom(l^.alum.vec, l^.alum.cantMaterias):0:2);
		l:= l^.sig;
	end;
end;

procedure max(v:materias; diml:integer ; var maxCod:integer ; var maxNota:real);
var 
	i: integer;
	
begin
	maxCod:= 0;
	maxNota:= -1;
	for i:= 1 to diml do begin
		if(v[i].nota > maxNota) then begin
			maxNota:= v[i].nota;
			maxCod:= v[i].cod;
		end;
	end;
end;

procedure armarNuevaLista(l:lista; var l2:lista2);
var 
	a2: alumno2;
	maxNota: real;
	maxCod: integer;
begin
	while(l <> nil) do begin
		a2.num:= l^.alum.num;
		max(l^.alum.vec,l^.alum.cantMaterias,maxCod,maxNota);
		a2.cod:= maxCod;
		a2.nota:= maxNota;
		agregarAdelante2(l2,a2);
		l:= l^.sig;
	end;
end;


var
	l:lista;
	l2:lista2;
BEGIN
	l:= nil;
	l2:= nil;
	armarLista(l);
	leerLista(l);
	armarNuevaLista(l,l2);
END.

{
   3.- Netflix ha publicado la lista de películas que estarán disponibles durante el mes de
diciembre de 2022. De cada película se conoce: código de película, código de género (1: acción,
2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélico, 7: documental y 8: terror) y puntaje
promedio otorgado por las críticas.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Lea los datos de películas, los almacene por orden de llegada y agrupados por código de
género, y retorne en una estructura de datos adecuada. La lectura finaliza cuando se lee el
código de la película -1. 
    
}
program practica01e3;
type
	genero = 1..8;

	peliculaAGuardar = record
		cod: integer;
		puntaje: real;
	end;
	
	pelicula = record
		gen: genero;
		ag: peliculaAGuardar;
	end;

	lista = ^nodo;
	nodo = record
		dato: peliculaAGuardar;
		sig: lista;
	end;

	vector = array [genero] of lista;

	vactorMejorPuntaje = array [genero] of pelicula;

procedure iniciarVector(var v: vector);
var
	i: genero;
begin
	for i:= 1 to 8 do 
		v[i]:= nil;
end;

procedure leerPelicula(var r: pelicula);
begin
	readln(r.ag.cod);
	if(r.ag.cod <> -1) then begin
		readln(r.ag.puntaje);
		readln(r.gen);
	end;
end;

procedure agregarAtras(var l: lista; r: peliculaAGuardar);
var
	nue, aux:lista;
begin
	new(nue); nue^.dato:= r; nue^.sig:= nil;
	
	if(l = nil) then l:= nue
	else begin
		aux:= l;
		while (l^.sig <> nil) do begin
			aux:= aux^.sig
		end;
		aux^.sig:= nue;
	end;
end;
	
procedure cargarPeliculas(var v:vector);
var
	r: pelicula;
begin
	leerPelicula(r);
	while (r.ag.cod <> -1) do begin
		agregarAtras(v[r.gen],r.ag);
		leerPelicula(r);
	end;
end;

procedure mejorPelicula(l: lista ;var r: peliculaAGuardar);
var
	maxPuntaje: real;
	maxPelicula: integer;
begin
	maxPuntaje:= -1;
	while(l <> nil) do begin
		if(maxPuntaje < l^.dato.puntaje)then begin
			maxPuntaje:= l^.dato.puntaje;
			maxPelicula:= l^.dato.cod;
		end;
		l := l^.sig;
	end;
	r.puntaje:= maxPuntaje;
	r.cod:= maxPelicula;
end;

procedure cargarMejorPeliculas(var v2: vactorMejorPuntaje; v:vector);
var
	i: genero;
	r: peliculaAGuardar;
begin
	for i:= 1 to 8 do begin
		mejorPelicula(v[i],r);
		v2[i].gen:= i;
		v2[i].ag:= r;
	end;
end;
	
procedure ordenarVector(var v: vactorMejorPuntaje);
var
	i,j,pos: genero;
	r: pelicula;
begin
	for i:= 1 to 8 - 1 do begin
		pos:= i;
		for j:= i + 1 to 8 do begin
			if (v[j].ag.puntaje < v[pos].ag.puntaje ) then pos:= j;
		end;
		r:= v[pos];
		v[pos]:= v[i];
		v[i]:= r;
	end; 
end;
	
procedure imprimir(v2: vactorMejorPuntaje);
begin
	writeln(v2[1].ag.cod);
	writeln(v2[8].ag.cod);
end;
	
var 
	v: vector;
	v2: vactorMejorPuntaje;
BEGIN
	iniciarVector(v);
	cargarPeliculas(v);
	cargarMejorPeliculas(v2,v);
	ordenarVector(v2);
	imprimir(v2);
END.


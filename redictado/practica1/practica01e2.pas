{
2.- El administrador de un edificio de oficinas cuenta, en papel, con la información del pago de
las expensas de dichas oficinas.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Genere un vector, sin orden, con a lo sumo las 300 oficinas que administra. De cada oficina
se ingresa el código de identificación, DNI del propietario y valor de la expensa. La lectura
finaliza cuando se ingresa el código de identificación -1, el cual no se procesa.
b. Ordene el vector, aplicando el método de inserción, por código de identificación de la
oficina.
c. Ordene el vector aplicando el método de selección, por código de identificación de la oficina.
   
}


program practica01e2;

const
	dimf = 300;

type
	
	oficina = record
		cod: integer;
		dni: integer;
		valor: real;
	end;
	
	vector = array [1..dimf] of oficina;	

procedure leerOficina(var r:oficina);
begin
	readln(r.cod);	
	if(r.cod <>-1) then begin
		readln(r.dni);
		readln(r.valor);
	end;
end;


procedure cargarVector(var v:vector ;var diml:integer);
var
	r: oficina;
begin
	diml:= 0;
	leerOficina(r);
	while(r.cod <> -1) and (diml < dimf) do begin
		diml:= diml + 1;
		v[diml]:= r;
		leerOficina(r);
	end;
end;

procedure ordenarVector1(var v:vector; diml:integer);
var
	i,j,pos: integer;
	r: oficina;
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

procedure ordenarVector2 (var v:vector ; diml:integer);
var
	i,j: integer;
	r: oficina;
begin
	for i:= 2 to diml do begin
		r:= v[i];
		j:= i-1;
		while(j > 0) and (v[j].cod > r.cod) do begin
			v[j + 1]:= v[j];
			j:= j - 1;
		end;
		v[j + 1]:= r;
	end;
end;

var 
	v: vector;
	diml: integer;
BEGIN
	cargarVector(v,diml);
	ordenarVector1(v,diml);
	ordenarVector2(v,diml);
END.


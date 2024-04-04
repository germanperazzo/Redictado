{
  El administrador de un edificio de oficinas, cuenta en papel, con la información del pago
de las expensas de dichas oficinas. Implementar un programa con:
a) Un módulo que retorne un vector, sin orden, con a lo sumo las 300 oficinas que
administra. Se debe leer, para cada oficina, el código de identificación, DNI del
propietario y valor de la expensa. La lectura finaliza cuando llega el código de
identificación -1.
b) Un módulo que reciba el vector retornado en a) y retorne dicho vector ordenado por
código de identificación de la oficina. Ordenar el vector aplicando uno de los métodos
vistos en la cursada.
c) Un módulo que realice una búsqueda dicotómica. Este módulo debe recibir el vector
generado en b) y un código de identificación de oficina. En el caso de encontrarlo,
debe retornar la posición del vector donde se encuentra y en caso contrario debe
retornar 0. Luego el programa debe informar el DNI del propietario o un cartel
indicando que no se encontró la oficina.
d) Un módulo recursivo que retorne el monto total de las expensas.
   
}


program repaso;
const	
	dimf = 300;
type
	
	oficina = record
		cod: integer;
		dni: integer;
		valor: real;
	end;	
	
	vector = array [1..dimf] of oficina;
	



procedure leerOficina(var r: oficina);
begin
	readln(r.cod);
	if (r.cod <> -1) then begin
		readln(r.dni);
		readln(r.valor);
	end;
end;


procedure cargarVector(var v:vector; var diml: integer);
var
 r: oficina;
begin
	diml:= 0;
	leerOficina(r);
	while(diml < dimf) and (R.cod <> -1) do begin
		diml:= diml + 1;
		v[diml]:= r;
		leerOficina(r);
	end;
end;

procedure ordenarVector(var v:vector; diml:integer);
var 
	i,j,pos: integer;
	r: oficina;
begin

	for i:=1 to diml - 1 do begin
		pos:= i;
		for j:= i + 1 to diml do 
			if(v[j].cod < v[pos].cod) then pos:= j;
		r:= v[pos];
		v[pos]:= v[i];
		v[i]:= r;	
	end;
end;
	
function busquedaBinaria(v: vector; ini,fin,x: integer):integer;
var
	medio: integer;
begin
	if(ini > fin)then 
		busquedaBinaria:= 0
	else begin
		medio:= (ini + fin) div 2;
		if(v[medio].cod = x) then 
			busquedaBinaria:= medio
		else
			if(v[medio].cod > x) then
				busquedaBinaria:= busquedaBinaria(v,ini,medio - 1,x)
			else
				busquedaBinaria:= busquedaBinaria(v,medio + 1,fin,x);		
	end;		
end;
	
procedure buscar(v: vector; diml:integer);
var
 x,y: integer;
begin
	readln(x);
	y:= busquedaBinaria(v,1,diml,x);
	if(y = 0) then
		writeln('no esta ese propietario')
	else
		writeln(v[y].dni);
end;	

function suma(v: vector; diml:integer):real;
begin
	if(diml = 0) then
		suma:= 0
	else
		suma:= v[diml].valor + suma(v,diml-1);	
end;	
	
var 
	v: vector;
	diml: integer;
BEGIN
	cargarVector(v,diml);
	if(diml = 0) then
		writeln('vector vacio')
	else begin	
		ordenarVector(v,diml);
		buscar(v,diml);
		writeln(suma(v,diml));
	end;	
END.


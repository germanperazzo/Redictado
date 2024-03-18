{
  4.- Escribir un programa con:
a. Un módulo recursivo que retorne un vector de 20 números enteros “random” mayores a 0 y
menores a 100.
b. Un módulo recursivo que devuelva el máximo valor del vector.
c. Un módulo recursivo que devuelva la suma de los valores contenidos en el vector.
5.- Implementar un módulo que realice una búsqueda dicotómica en un vector, utilizando el
siguiente encabezado:
 Procedure busquedaDicotomica (v: vector; ini,fin: indice; dato:integer; var pos: indice);
Nota: El parámetro “pos” debe retornar la posición del dato o -1 si el dato no se
encuentra en el vector.
   
   
}


program practica02e4y5;
const dimF = 20;
type
	vector = array [1..dimF] of integer;

procedure CargarVector (var v: vector; var dimL: integer);

  procedure CargarVectorRecursivo (var v: vector; var dimL: integer);
  var x: integer;
  begin
    x:=random(100);  
    if (x <> 0 ) and (dimL < dimF) 
    then begin
          dimL:= dimL + 1;
          v[dimL]:= x;
          CargarVectorRecursivo (v, dimL);
         end;
  end;
  
begin
  dimL:= 0;
  CargarVectorRecursivo (v, dimL);
end;
 
procedure imprimirVector(v:vector; dimL:integer );
var
	i:integer;
begin
	for i:=1 to dimL do
		writeln(v[i]);
end; 

procedure maximo(v:vector;var max:integer; dimL:integer );
begin
	if(diml > 0) then begin
		if(v[diml]>max) then 
			max:=v[diml];
		maximo(v,max,dimL - 1);
	end;	
end;

procedure suma(v:vector; var s:integer; diml:integer);
begin
    if (diml > 0) then begin
        s:=s+v[diml];
        suma(v,s,diml-1);
    end;
end;

procedure ordenarVector(var v:vector);
var
    i,j,x,pos:integer;
    
begin
    for i:=1 to dimF-1 do begin
		pos:=i;
        for j:=i+1 to dimF do begin
            if(v[j]<v[pos]) then begin
               pos:=j;
            end;
         x:=v[pos];
         v[pos]:=v[i];
         v[i]:=x;    
        end;
    end;
end;


function busquedaDicotomica(v: vector; ini,fin,dato: integer):integer;
var
    medio:integer;
begin
    if (ini>fin) then begin
        busquedaDicotomica := -1;
    end
    else begin
        medio := (ini+fin) div 2;
        
    if (v[medio] = dato) then begin
            busquedaDicotomica:= medio;
    end
    else if (v[medio] > dato) then
        busquedaDicotomica:= busquedaDicotomica(v, ini, medio-1, dato) // Buscar en la izquierda
    else
        busquedaDicotomica:= busquedaDicotomica(v, medio+1, fin, dato); // Buscar en la derecha
    end;
end;
	
var 
	diml,maxi,s,z:integer;
	v:vector;
BEGIN
	maxi:= -1;
	CargarVector(v,diml);
	writeln('..................a');
	writeln(diml);
	imprimirVector(v,diml);
	writeln('a..................');
	maximo(v,maxi,dimL);
	writeln(maxi);
	suma(v,s,diml);
	writeln(s);
	ordenarVector(v);
	writeln('................');
	writeln(v[1]);
	readln(z);
	writeln(busquedaDicotomica(v,1,dimL,z));
	
END.


{
  3.- Escribir un programa que:
a. Implemente un módulo recursivo que genere una lista de números enteros “random”
mayores a 0 y menores a 100. Finalizar con el número 0.
b. Implemente un módulo recursivo que devuelva el mínimo valor de la lista.
c. Implemente un módulo recursivo que devuelva el máximo valor de la lista.
d. Implemente un módulo recursivo que devuelva verdadero si un valor determinado se
encuentra en la lista o falso en caso contrario.  
   
}


program practica02e3;

type
	lista = ^nodo;
	
	nodo = record
		dato:integer;
		sig:lista;
	end;

procedure crearLista(var l:lista);
var
	x:integer;
	nue:lista;
begin
	readln(x);
	if(x<>0) then begin
		 crearLista(l);
		 new (nue);
         nue^.dato:= x;
         nue^.sig:= l;
         l:= nue;
	end
	else l:= nil;
end;

procedure imprimirRecursivaLista(l:lista);
begin
    if (l <> nil) then begin
        writeln(l^.dato);
        imprimirRecursivaLista(l^.sig);
    end;
end;

procedure min(l:lista;var n:integer);
begin
	if (l<>nil) then begin
        if (l^.dato < n) then 
            n:=l^.dato;
        min(l^.sig,n);
    end;
end;

procedure max(l:lista;var n:integer);
begin
	if (l<>nil) then begin
        if (l^.dato > n) then 
            n:=l^.dato;
        max(l^.sig,n);
    end;
end;

function esta(l:lista; n:integer):boolean;
begin
	if (l<>nil) then begin
        if (l^.dato = n) then 
            esta:=true
        else
			esta:=esta(l^.sig,n);
    end;
end;

var 
	l: lista;
	x,m,n :integer;
BEGIN
	m:=-1;
	n:=999;
	crearLista(l);
	imprimirRecursivaLista(l);
	min(l,n);
	writeln('a');
	writeln(n);
	max(l,m);
	writeln('a');
	writeln(m);
	readln(x);
	writeln(esta(l,x));
END.


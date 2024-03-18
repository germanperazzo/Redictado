{
   practica02e2.pas
   
   Copyright 2024 Chorizard <Chorizard@DESKTOP-FJOK9P7>
   
   This program is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation; either version 2 of the License, or
   (at your option) any later version.
   
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
   
   You should have received a copy of the GNU General Public License
   along with this program; if not, write to the Free Software
   Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
   MA 02110-1301, USA.
   
   
}


program practica02e2;


procedure descomponer(x: integer);
var
    digito:integer;
begin
    if (x <> 0) then begin
        digito:= x mod 10;
        x:= x div 10;
        descomponer(x);
        write(digito,' ');
    end;
end;

var
    x:integer;
    
begin
	readln(x);
    while (x <> 0) do begin
		descomponer(x);
		readln(x);
    end;
end.

link(a,b).
link(b,p).
link(b,c).
link(c,d).
link(d,q).
link(d,r).

connected(X,Y):-link(X,Y);link(Y,X).

has_path(X,Y,I) :-
   connected(X,Y),
   \+ member(Y,I).
has_path(X,Y,I) :-
	connected(X,Z),
	\+ member(Z,I),
	has_path(Z,Y,[Z|I]).
path(X,Y) :-has_path(X,Y,[X]).


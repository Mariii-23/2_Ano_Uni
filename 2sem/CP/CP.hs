-- | Cálculo de Programas 2020/2021

module CP where

infix 5 ><

-- Basic Functions

-- zero = const 0

-- Product

split :: (a->b)->(a->c)->a->(b,c)
split f g x = (f x, g x)

(><) :: (a->b)->(c->d)->(a,c)->(b,d)
f >< g = split (f.p1) (g.p2)

-- Isomorphisms

swap :: (a,b) -> (b,a)
swap = split p2 p1

assocl :: (a,(b,c)) -> ((a,b),c)
assocl = split ( id >< p1 ) ( p2.p2 )

assocr :: ((a,b),c)->(a,(b,c))
assocr = split ( p1.p1 ) ( p2 >< id )
  
-- Abbreviations
  
p1 :: (a,b)->a
p1 = fst

p2 :: (a,b)->b
p2 = snd

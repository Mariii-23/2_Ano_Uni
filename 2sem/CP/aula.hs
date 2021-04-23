-- | 

-- module aula.hs where

-- import Cp.hs

inL = either nil const

outL [] = i1()
outL (h:t) = i2(h,t) 

fL k = id -|- id >< k

cataL g = g .fL(cataL g).outL

multip = cataL g where
  g=either g1 g2
  g1= const 1
  g2(a,b)=a*b

multip [11,-1,2,0,3,4]
-- 0


rev = cataL (either nil g2) where
  g2(a,as)=as++[a]

 
rev [11,-1,2,0,3,4]
-- lista revertida

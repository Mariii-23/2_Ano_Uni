module COMPOSE  where

-- f-> functor
-- g-> fucntor
-- a value
data Compose f g a = Compose{
      getCompose :: f (g a)
  } deriving Show

instance (Functor f, Functor g) => Functor (Compose f g)
  where
    fmap f (Compose c) = Compose ((f <$>) <$> c)

--instance (Applicative f, Applicative g) => (Compose f g)
--  where
--    pure = Compose . pure . pure
--    Compose c1 <*> Compose c2 = Compose ((<*>) <$> c1<*>c2)

-- instance (Applicative f, Applicative g, Semigroup a) =>
--     Semigroup (Compose f g s) where
--   c1 <> c2 = (<>) <$> c1 <*> c2

-- instance (Monad f, Monad g) => Monad (Compose f g)
--   where
--     c1 >>= f =

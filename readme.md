## graphql-builder-repro

### Repro for issue with graphql-builder

* Clone the repo
* Run `yarn install` to install js deps
* Run `yarn global add exp` to install expo
* Run `rlwrap lein figwheel` to start figwheel
* Run `exp start --ios --lan` to start expo


### The problem 

`parser/defgraphql` works ok, but `core/query-map` produces an empty map. 

It is the call to `cuerdas/kebab` that fails, due to `goog.nodeGlobalRequire` is not a function.

The problem can be fixed by removing `:target :nodejs` from compiler options, 
however this breaks other things on larger projects (reagent 0.8/react 16 compatability)




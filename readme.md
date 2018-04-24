## graphql-builder-repro

### Repro for issue with graphql-builder

* Clone the repo
* Run `yarn install` to install js deps
* Run `yarn global add exp` to install expo
* Run `rlwrap lein figwheel` to start figwheel
* Run `exp start --ios --lan` to start expo


### The problem 

`parser/defgraphql` works ok, but `core/query-map` produces an empty map. 

On further investigation, it is the call to `cuerdas/kebab` that fails. 

It depends on an external library `xregexp` 

# Kotlin Playground

- [Main.kt](src/main/kotlin/Main.kt) - no package; no semicolon

## Basics
- [Hello1](src/main/kotlin/basics/Hello1.kt), [Hello2](src/main/kotlin/basics/Hello2.kt) - top-level function; main with args & no args; string templates, Array syntax & wrappers; if expression
- [Variables](src/main/kotlin/basics/Variables.kt) - read-only & mutable variables; type inference
- [Functions1](src/main/kotlin/basics/Functions1.kt), [Functions2](src/main/kotlin/basics/Functions2.kt), [FunctionsJ](src/main/kotlin/basics/FunctionsJ.java) - expression body; Unit; top-level, member, local; calling from Java; named & default args; @JvmOverloads

## Control Structures
- [Conditionals](src/main/kotlin/cstruct/Conditionals.kt) - if & when; is & smart cast;  
- [Loops](src/main/kotlin/cstruct/Loops.kt) - for, in, ranges
- [InChecksAndRanges](src/main/kotlin/cstruct/InChecksAndRanges.kt) - in use cases; ranges
- [CheckingIdentifier](src/main/kotlin/cstruct/CheckingIdentifier.kt) - small task to practice ranges
- [Exceptions](src/main/kotlin/cstruct/Exceptions.kt) - no checked/unchecked; throw & try expressions; @Throws

## Extensions
- [ExtensionFunctions](src/main/kotlin/extensions/ExtensionFunctions.kt) - extension functions, examples, standard library
- [SumExtensionFunction](src/main/kotlin/extensions/SumExtensionFunction.kt) - small task to create extension function
- [CallingExtensions](src/main/kotlin/extensions/CallingExtensions.kt) - how extensions interact with inheritance and can extensions hide members
- With extensions, we can keep our classes and interfaces APIs minimal and write everything else as extension, but keep them close together.
- We can use extensions when we don't control some class or interface, many existing Java libraries have companion libraries with a number of extensions.

## Nullability
- [NullableTypes](src/main/kotlin/nullability/NullableTypes.kt) - nullable types; nullability operators
- [EmptyOrNull](src/main/kotlin/nullability/EmptyOrNull.kt) - small task to check if string is null or empty
- [SafeCasts](src/main/kotlin/nullability/SafeCasts.kt) - a safe way to cast an expression to a type
- Nullability is very [important](https://kotlinlang.org/docs/null-safety.html)

## Functional Programming
- [Lambdas](src/main/kotlin/functional/Lambdas.kt) - lambda syntax
- [CollectionsOps](src/main/kotlin/functional/CollectionsOps.kt) - common operations on collections
- [OperationsQuiz](src/main/kotlin/functional/OperationsQuiz.kt) - practice common operations on collections
- [InterchangeablePredicates](src/main/kotlin/functional/InterchangeablePredicates.kt) - small task to practice none, any, all
- [FunctionTypes](src/main/kotlin/functional/FunctionTypes.kt) - function types, nullability
- [MemberReferences](src/main/kotlin/functional/MemberReferences.kt) - member references, function references, bound, non-bound
- [ReturnFromLambda](src/main/kotlin/functional/ReturnFromLambda.kt) - how return behaves with lambdas
- Kotlin is not purely functional language, but rather combines OOP and functional styles

# Properties
- [Properties](src/main/kotlin/properties/Properties.kt) - properties, fields, accessors
- [InterfaceAndExtProperties](src/main/kotlin/properties/InterfaceAndExtProperties.kt) - properties in interfaces, extension properties
- [LazyAndLateInit](src/main/kotlin/properties/LazyAndLateInit.kt) - lazy properties, late initialization

# OOP
- Defaults are different in Kotlin - `public` and `final` by default
- If you want to make it non-final, you have to set it explicitly as `open`
- No package private visibility in Kotlin, use `internal` for that - visible in module
- Module is a set of Kotlin files compiled together (IntelliJ IDEA, Maven project, Gradle source set)
- So we have there modifiers: `public`, `protected` `private`, `internal`. Then: `final`, `open`, `abstract`. Also `override`.
- In Kotlin we can have multiple classes in the same file, while in Java we prefer one class per file. One file can additionally contain multiple top-level functions, properties, etc.
- In Kotlin, package doesn't have to correspond to directory structure - we can have `org.company.store` package, but it can be physically located in top level `store` folder for example. Good recommendatioon is to simply omit `org.company` or `org.company.project` from directory structure.
- [CtxInherit](src/main/kotlin/oop/CtxInherit.kt) - constructors, inheritance syntax
- [ClassModifiers](src/main/kotlin/oop/ClassModifiers.kt) - class modifiers, enum, data, equality, sealed, inner, nested, class delegation
- [Objects](src/main/kotlin/oop/Objects.kt) - objects, object declaration, object expression, companion object, "static" members
- [Constants](src/main/kotlin/oop/Constants.kt) - constants... 
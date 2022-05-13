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
- [EmptyOrNull](src/main/kotlin/nullability/SafeCasts.kt) - a safe way to cast an expression to a type
# Exercixe 1.2
A Dyck word is a sequence of +1's and -1's with the property that the sum of any prefix of the sequence is never negative.
For example, +1, -1, +1, -1 is a Dyck word, but +1, -1, -1, +1 is not a Dyck word. 
Describe any relationship between Dyck words and Stack push(x) and pop() operations.

# Relationship Between Dyck word and Stack push(x) and pop()
Like the Dyck word, the normal operation on a stack should start with a push(x) operation followed by either push(x) or pop()
but the number of pop() must not exceed the preceding push(x) operations - it is not advisable to call pop() on an empty stack. 
Calling pop() on an empty stack will throw EmptyStackException in java.
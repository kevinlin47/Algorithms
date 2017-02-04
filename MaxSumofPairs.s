#Kevin Lin 151001783	

#Program gets four integers from the user

#and calculates the sum of differences 

#of all pairs created with these numbers.


.data



prompt1: .asciiz "Enter first number: "

prompt2: .asciiz "Enter second number: "

prompt3: .asciiz "Enter third number: "

prompt4: .asciiz "Enter fourth number: "

sum: .asciiz "Sum of difference of all pairs = "

.align 4

userNumbers: .space 16 #allocate space for 4 integers

.text


main:


li $v0,4 #Display prompt for first number

la $a0,prompt1 #get address for prompt1 string

syscall


li $v0,5 #Ask user for first number

syscall
move $t0, $v0 #Place value into register $t0



li $v0,4 #Display prompt for second number

la $a0,prompt2 #get address for prompt2 string

syscall


li $v0,5 #Ask user for second number

syscall

move $t1, $v0 #place value into register $t1



li $v0, 4 #Display prompts for third number
la $a0, prompt3 #get address for prompt3 string
syscall
li $v0,5 #ask user for third number
syscall
move $t2, $v0 #place value into register $t2

li $v0, 4 #Display prompt for fourth number
la $a0, prompt4 #get address for prompt4 string
syscall
li $v0,5 #Ask user for fourth number
syscall
move $t3,$v0 #place value into register $t3

addi $s0,$zero,0 #Using register $s0 as Index
sw $t0,userNumbers($s0) #store first number in index 0 of array

addi $s0,$s0,4 #update array index
sw $t1,userNumbers($s0) #store second number in index 1 of array

addi $s0,$s0,4 #update array index
sw $t2,userNumbers($s0) #store third number in index 2 of array

addi $s0,$s0,4 #update array index
sw $t3,userNumbers($s0) #store fourth number in index 3 of array

addi $s0,$zero,0 #set iteration to 0
addi $s2, $zero,0 #set iteration to 0 for inner loop
li $s1,4 #set register $s1 to constant 4	

li $t4,0 #set sum to zero, going to store sum in resiter $t4
li $t7,0 #temp location to store difference of two numbers

outerLoop:
mul $t5,$s0,$s1 #array index
addi $s0,$s0,1 #increment iterator 
ble $s1, $s0, endOuter #branch if register $s1<$s0

add $s2,$s0,$zero
innerLoop:
ble $s1,$s2,endInner
mul $t6,$s2,$s1
lw $s6,userNumbers($t5) #get first number from pair
lw $s7, userNumbers($t6) #get second number from pair
sub $t7,$s6,$s7 #subtract the pair of numbers
sub $t8,$s7,$s6 #subtract pair in reverse order
bgez $t7, firstPair #branch if first pair is positive
bgez $t8, secondPair #branch if second pair is positive
firstPair:#if first pair is postivie then add that to the sum
add $t4,$t4,$t7 #add the difference to the current sum
addi $s2,$s2,1 #increment iterator 
j innerLoop #jump back to inner loop
secondPair: #if second pair is positive then add that to the sum
add $t4,$t4,$t8 #add the difference to the current sum
addi $s2,$s2,1 #increment iterator 
j innerLoop #jump back to inner loop
endInner: #end inner loop

j outerLoop #jump back to outer loop
endOuter: #end loop

li $v0,4 #Display sum to user string 
la $a0,sum
syscall

li $v0,1 #Display sum to user
la $a0,0($t4)
syscall


li $v0,10 
syscall
 #Exit the program

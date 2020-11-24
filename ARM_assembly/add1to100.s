.section .data
	var1: .byte 0 @数值位
	sum: .word 0
	l: .set var1_size, sum - var1
	result_str: .asciz "Result: %d\n"
	
	stdout_buf: .asciz "\0\0\0\0\0\0\0\0\0"
	after_stdout_buf: .equ stdout_buf_l, after_stdout_buf - stdout_buf
.section .text
.global main

main:
	ldr  r0,var1_addr @读取var1的地址
	ldrb r0,[r0] @读取var1的值

	ldr  r1,sum_addr @读取sum的地址
	ldr  r1,[r1] @读取sum的值

	@for(byte r0 = 0;r0 <= 100;r1++)
	back_for: cmp r0,#100
			  bgt out_for
			  shit:
			  add r1,r0,r1 @r0+=r1
			  add r0,r0,#1 @i++
			  b back_for
	out_for:  
			  ldr r0,sum_addr
			  str r1,[r0]

	@打印输出
	ldr r0,str_addr
	ldr r1,sum_addr
	ldr r1,[r1]
	bl printf

_exit:
	mov r0,#0
	mov r7,#1
	swi #0

var1_addr: .word var1
sum_addr: .word sum
str_addr: .word result_str

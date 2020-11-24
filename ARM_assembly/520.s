.section .data @内存数据区
	var1: .byte 105
		  .byte 32
		  .byte 108
		  .byte 111
		  .byte 118
		  .byte 101
		  .byte 32
		  .byte 121
		  .byte 111
		  .byte 117
		  .byte 10
		  .byte 0
	after_var1: .set var1_l, after_var1 - var1

.section .text @内存代码区
.global _start

_start:
	@ldr r0,var1_addr
	@ldr r1,[r0]
	@add r1,r1,#4
	@str r1,[r0]

	mov r0,#1
	ldr r1,var1_addr
	mov r2,#var1_l
	mov r7,#4
	swi #0

	mov r0,#0
	mov r7,#1
	swi #0

@var1的地址
var1_addr: .word var1

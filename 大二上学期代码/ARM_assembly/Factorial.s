.section .data
    input_string: .asciz "%d\n"
    input_n:      .word  0
.section .text

.global main

main:
    ldr r0,=input_string          @等价于scanf("%d",&input_n)
    ldr r1,=input_n
    bl scanf

    ldr r0,=input_n
    ldr r0,[r0]
    bl _factor                    @等价于_factor(input_n)
    pop {r1}
    
    ldr r0,=input_string

    bl printf
        
    mov r0,#0
    mov r7,#1
    swi #0


_factor:
    cmp r0,#1
    bne next                      @if(r0==1) { return 1; }
    push {r0} @堆栈保存结果        @等价于return 1
    mov pc,lr
    next:
    @保存当前状态
    push {r0}
    push {lr}
    sub r0,r0,#1
    bl _factor                   @等价于_factor(r0-1)
    @取出运算结果
    pop {r1}
    pop {lr}
    pop {r0}
    @计算当前级结果
    mov r2,r0
    mul r1,r2,r1
    push {r1} @保存当前级结果
    mov pc,lr 



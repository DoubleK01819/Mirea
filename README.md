### Работу выполнил Катков Кирилл ИВБО-04-20
<br><br>

# Отчет
## Требования:
* Бесконечные скобки
* Базовые арифметические операции
* For + While
* ArrayList + HashMap

## Грамматика:
```
lang -> expr+
  expr -> (assign_expr | stmt_if | loop_while | loop_for | io_console)
    assign_expr -> init ';3'
        init -> IDENT ASSIGN_OP value
        value -> Compare | Condition | MathOpt | MulDiv | Brackets | UnValue
          Compare -> value (comp_token value)
            comp_token -> COMP_LESS | COMP_L_EQ | COMP_MORE | COMP_M_EQ | COMP_EQ | COMP_NEQ
          condition -> value comp_token value
          AddSub -> value (PLUS | SUB_OP value)
          MulDiv -> value (MINUS | DIV_OP value)
          Brackets -> '(' value ')'
          UnValue -> INT | IDENT | STRING
    io_console -> KW_WRITER value ‘;3' $$ KW_READER..
    stmt_loop_for -> KW_FOR '(' init ';' condition ';' expr ')' stmt_body
      stmt_body -> '{' expr+ '}'
    stmt_loop_while -> KW_WHILE '(' condition ')' stmt_body
    stmt_if -> KW_IF '(' condition ')' stmt_body stmt_else?
      stmt_else -> KW_ELSE stmt_body
```

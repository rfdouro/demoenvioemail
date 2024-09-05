# Projeto de exemplo para envio de e-mail usando `JAVA`

Exemplo de envio de e-mail usando SMTP do Office 365

### Fontes
Para pesquisas mais aprofundadas:

* [Jakarta Mail Spec](https://jakarta.ee/specifications/mail/2.0/jakarta-mail-spec-2.0)
* [Jakarta Mail API](https://jakartaee.github.io/mail-api/)
* [Jakarta Mail Github](https://github.com/jakartaee/mail-api)
* [Angus Mail - Eclipse](https://eclipse-ee4j.github.io/angus-mail/)
* [Angus Mail - Eclipse - Github](https://github.com/eclipse-ee4j/angus-mail)

## Dados sobre o provedor

* [Setup Office 365](https://learn.microsoft.com/en-us/exchange/mail-flow-best-practices/how-to-set-up-a-multifunction-device-or-application-to-send-email-using-microsoft-365-or-office-365)

## Compilando a aplicação

```
mvn clean package
```

## Executando a aplicação

```
java -jar target\Tmail.jar email@de senha email@para "assunto aqui" "mensagem aqui"
```
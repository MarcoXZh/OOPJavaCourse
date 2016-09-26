# Assignment 2: Java Regular Expressions

  - Source code: [*CookieTest.java*][Code1]


## Valid or invalid that is the question?

Web applications have several challenges; perhaps the most serious being the difficultly in maintaining state
information. A common solution to this issue is to use cookies as a mechanism to encode and distribute this information.
However, as the cookie passes from a server to a client and back neither side can assume that the cookie is valid.

Traditionally, cookies are defined by [*RFC 6265 (HTTP State Management Mechanism)*][RFC6265]. This document provides a
precise definition of what is a valid cookie.

**You are required to produce a Java program, which uses the regular expression to answer the question: "Is this cookie
(supplied as an input) valid or not?"**

Where validity means corresponding to the definition found in RFC 6265 (Section 4.1.1):

```sh
  set-cookie-header = "Set-Cookie:" SP set-cookie-string
  set-cookie-string = cookie-pair *( ";" SP cookie-av )
  cookie-pair       = cookie-name "=" cookie-value
  cookie-name       = token
  cookie-value      = *cookie-octet / ( DQUOTE *cookie-octet DQUOTE )
  cookie-octet      = %x21 / %x23-2B / %x2D-3A / %x3C-5B / %x5D-7E
                        ; US-ASCII characters excluding CTLs,
                        ; whitespace DQUOTE, comma, semicolon,
                        ; and backslash
  token             = <token, defined in [RFC2616], Section 2.2>
  cookie-av         = expires-av / max-age-av / domain-av /
                      path-av / secure-av / httponly-av /
                      extension-av
  expires-av        = "Expires=" sane-cookie-date
  sane-cookie-date  = <rfc1123-date, defined in [RFC2616], Section 3.3.1>
  max-age-av        = "Max-Age=" non-zero-digit *DIGIT
                        ; In practice, both expires-av and max-age-av
                        ; are limited to dates representable by the
                        ; user agent.
  non-zero-digit    = %x31-39
                        ; digits 1 through 9
  domain-av         = "Domain=" domain-value
  domain-value      = <subdomain>
                        ; defined in [RFC1034], Section 3.5, as
                        ; enhanced by [RFC1123], Section 2.1
  path-av           = "Path=" path-value
  path-value        = <any CHAR except CTLs or ";">
  secure-av         = "Secure"
  httponly-av       = "HttpOnly"
  extension-av      = <any CHAR except CTLs or ";">
```

Hint: to understand the definition, you may need [*Augmented Backus-Naur Form*][A-BNF].


## Examples/Testcases

Here are the examples of cookies (test cases, both valid and invalid) to assist you in constructing such a program.
Cookie 1 to 6 are legal; whereas Cookies 7 to 17 are illegal.

```sh
HTTP/1.x 200 OK
Server: Apache-Coyote/1.1

 1. Set-Cookie: ns1="alss/0.foobar^"                         # name=value
 2. Set-Cookie: ns1=                                         # empty value
 3. Set-Cookie: ns1=; Expires=Wed, 19 Nov 2008 16:35:39 GMT  # Expires=time_stamp
 4. Set-Cookie: ns1=; Domain=                                # empty Domain
 5. Set-Cookie: ns1=; Domain=.srv.a.com-0                    # Domain=host_name
 6. Set-Cookie: lu=Rg3v;Expires=Wed, 19 Nov 2008 16:35:39 GMT; Path=/; Domain=.example.com; HttpOnly
 7. Set-Cookie:                                              # empty cookie-pair
 8. Set-Cookie: sd                                           # no "="
 9. Set-Cookie: =alss/0.foobar^                              # empty name
10. Set-Cookie: ns@1=alss/0.foobar^                          # illegal name
11. Set-Cookie: ns1=alss/0.foobar^;                          # trailing ";"
12. Set-Cookie: ns1=; Expires=Wed 19 Nov 2008 16:35:39 GMT   # illegal Expires value
13. Set-Cookie: ns1=alss/0.foobar^; Max-Age=01               # illegal Max-Age: starting 0
14. Set-Cookie: ns1=alss/0.foobar^; Domain=.0com             # illegal Domain: starting 0
15. Set-Cookie: ns1=alss/0.foobar^; Domain=.com-             # trailing non-letter-digit Domain
16. Set-Cookie: ns1=alss/0.foobar^; Path=                    # empty Path
17. Set-Cookie: ns1=alss/0.foobar^; httponly                 # lower case of "HttpOnly"

Cache-Control: private
Pragma: no-cache
Content-Encoding: gzip
Content-Type: text/html;charset=UTF-8
Content-Length: 22784
Date: Tue, 18 Nov 2008 16:35:39 GMT
```

**NOTE**: according to RFC6265, the `extension-av` can be any non-control ASCII character except `;` (semi-colon).
Therefore, Cookie 12 to 17 are actually legal, where the illegal `Expires`, `Max-Age`, etc. are legal `extension-av`s.
In this assignment, we do NOT use `extension-av`:

```sh
  ... ...
  cookie-av         = expires-av / max-age-av / domain-av /
                      path-av / secure-av / httponly-av
  ... ...
```


[Code1]: https://github.com/MarcoXZh/OOPJavaCourse/blob/master/Assignment2%20Java%20Regular%20Expressions/CookieTest.java
[RFC6265]: http://tools.ietf.org/html/rfc6265
[A-BNF]: https://en.wikipedia.org/wiki/Augmented_Backus%E2%80%93Naur_Form

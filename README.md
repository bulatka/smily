# smily
Language greatly inspired by Brainfuck and designed just for fun! ;)

Language rules:
- @see org.bulatnig.smily.Command for list of available commands
- put OUTPUT after each character
- don't put OUTPUT at the end of line
- new line starts with NEW_LINE
- CRLF and LF encoded and decoded as LF
- NEW_LINE decoded as LF

Example execution:

    mvn clean package
    java -jar target/smily-1.0-SNAPSHOT.jar encode input.txt
    java -jar target/smily-1.0-SNAPSHOT.jar decode encoded.out

Implementation notes:
- "encode" proccess encodes input text to Smily program which produces that text
- "decode" proccess decodes Smily program to text that it intended to produce
- language interpreter not implemented
- two NEW_LINE's without text between decoded as one

Example text:

    The Elephant by Hilaire Belloc

    When people call this beast to mind,
    They marvel more and more
    At such a little tail behind,
    So large a trunk before.

Encoded output:

    ;)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):)))))))))))))))))))):(((:(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:))))))))))))))))))))))))))))))))))))):))))))))))))))))))))))))))))))))))))))):(((((((:))))))))))):((((((((:(((((((:))))))))))))):)))))):((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):))))))))))))))))))))))):(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:)))))))))))))))))))))))))))))))))))))))):))))))))))))))))))))))))))))))))):))):(((((((((((:)))))))):))))))))):(((((((((((((:(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:)))))))))))))))))))))))))))))))))):))))))))))))))))))))))))))))))))))):)))))))::))):((((((((((((

    ;))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):))))))))))))))))):(((:))))))))):((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):(((((((((((:)))))))))):):((((:(((((((:(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):((:)))))))))))::((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):((((((((((((:):)))))))))):(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):))):((((:)))))))))))))))))):):((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):(((((:(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):((((:))))):((((((((((:((((((((((((((((((((((((((((((((((((((((((((((((((((((((
    ;)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):)))))))))))))))))))):(((:)))))))))))))))))))):(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):((((((((((((:))))))))))))))))):)))):(((((((((((((((((:))))))):((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):)):))):(((((((((((((:(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):))))))))))))):((((((((((:((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):)):))):(((((((((((((
    ;))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):))))))))))))))))))))))))))))))))))))))))))))))))))):((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):)):((((((((((((((((((:))))):((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):(((:)))))))))))::((((((((:(((((((:(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):(((((((((((((((((((:)))))))):))):((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):))):))):):))))):((((((((((:((((((((((((((((((((((((((((((((((((((((((((((((((((((((
    ;))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):)))))))))))))))))))))))))))):(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):(((((((((((:))))))))))))))))):(((((((((((:((:(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):((:))):(((((((:(((:(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((:)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))):))):):))))))))):))):(((((((((((((:(((((((((((((((((((((((((((((((((((((((((((((((((((((((
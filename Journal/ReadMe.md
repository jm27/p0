# Journal Dev Notes

![Journal-IMG](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.kinja-img.com%2Fgawker-media%2Fimage%2Fupload%2Fs--wJheb3C0--%2Fc_fill%2Cfl_progressive%2Cg_center%2Ch_450%2Cq_80%2Cw_800%2F641522534013585731.jpg&f=1&nofb=1)

## Overview
Personal Journal of notes from Lectures. 
This program allows user to create notes and
save them, to be retrieved when needed.

## Actors & Features

- A User can:
    - Use CLI to command application.
    - Create entries for Journal with custom or default name.
    - Specify file to read, edit or delete.
- The Application can:
    - Accept User input from the CLI.
    - Create, Delete, Read, Edit files from a specified folder.
    - Get files and list them.

## Usage
    
Clone repository:
    
    In your terminal type:
    git clone 'https://github.com/jm27/p0.git'

Change directory

    In your terminal type:
    cd p0/
    
Compile

    In your terminal type:
    mvn compile

Run

    In your terminal type:
    mvn exec:java

This will start the application, 
you should see the following message with commands.
    
    welcome to your personal journal please type: create, write, read, delete or exit

- Create will let the user create a new entry with a custom name or default name
- Write will let the user edit an entry.
- Read will let the user edit an entry.
- Delete will let the user edit an entry.
- Exit will close the journal application.

## Future goals

- Add Database connection.
- Create server.
- Create user interface.

## Acknowledgments

Thanks to our teacher Mehrab and teammates!
2021 Sakura Matrix P0
#!/usr/bin/python
# -*- coding: utf-8 -*-

import os

# include <stdio.h>
# include <stdlib.h>

while 1:
    commande = input('Entrez une commande \n')
    pid = os.fork()
    lng = len(commande)
    dernierchar = commande[lng - 1]
    tblcmd = commande.split()
    status = 0

    if pid == 0:
        if dernierchar == '&':
            try:
                os.execvp(tblcmd[0], tblcmd[0:len(tblcmd) - 1])
            except OSError as e:
                errno = e.get_er
                os.sterror('Commande inconnue ', e.strerror)
                fflush(stdout)
        else:
            try:
                os.execvp(tblcmd[0], tblcmd[0:])
            except OSError as e:
                errno = e.get_er
                os.sterror('Commande inconnue ', e.strerror)
                fflush(stdout)
    elif pid > 0:

        if dernierchar == '&':
            print('Execution en arriere plan')
        else:
            status = os.wait()
            print('Pid du fils ', status[0])
            print('code de retour ', status[1])
    else:
        print ('erreur du fork')


			
	


	

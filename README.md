# Moteur d'inférence utilisant le chaînage avant et arrière

## Entrées :

-   fichier de règles : data/regles.txt

-   format :

    -   PREMISS,PREMISS,...    ACTION

## Sorties:

-   Chaînage avant: 

    Le programme va chercher en fonction de la base de fait si le patient meurt ou non.

-   Chaînage arrière:

    Le programme cherche à savoir si une action est vérifié (par défaut la MORT mais peut-être modifié). Il va valider si chaque premiss nécessaire pour le but à atteindre est dans la base de fait.

-   Tri par nombre de premiss:

    Possibilité de trier la base de règles par le nombre de premiss dans chaque règle.

-   Cohérence:

    Affiche si la base de règles est cohérente ou non.

## Vocabulaire :

-   Faits :
    1. COURBATURE           : si le patient a des courbatures
    2. FATIGUE              : si le patient est fatigué
    3. FIEVRE               : si le patient a de la fièvre
    4. GRIPPE               : si le patient a la grippe
    5. TOUX                 : si le patient tousse
    6. SUEURS_FROIDES       : si le patient a des sueurs froides
    7. COVID                : si le patient a le covid
    8. FRAGILE              : si le patient est fragile
    9. VIEUX                : si le patient a plus de 80 ans
    10. MALAISE             : si le patient est victime de malaise
    11. MAUX_DE_TETE        : si le patient a des maux de tête
    12. PRESSION            : si le patient a une pression élevée
    13. COMPLICATIONS       : si le patient a des complications liées au covid ou a la grippe
    14. PAS_BON_MEDECIN     : si le patient n'a pas un bon médecin

## Détails :

-   Il se peut que enchainer les évaluations de la base de fait ne marche pas au bout d'un moment, mais relancer l'application résout tous les problèmes.
%LANG: OCTAVE
x = dlmread("matrix.txt", SEP=' ', R0=1, C0=0);
x .^ -1

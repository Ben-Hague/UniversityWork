function [Word] = findWord(Gesture)
%This Function Finds the Word that each Gesture Reference refers to
%   the appropriate word is saved into variable word and output from the
%   function
    switch Gesture
        case 1
            Word = 'Biscuit';
        case 2
            Word = 'Building';
        case 3
            Word = 'Circle';
        case 4
            Word = 'Ghost';
        case 5
            Word = 'Penguin';
        case 6
            Word = 'Reindeer';
        case 7
            Word = 'Sea';
        case 8
            Word = 'Space';      
        case 9
            Word = 'Squirrel';    
        case 10
            Word = 'You';
            
end


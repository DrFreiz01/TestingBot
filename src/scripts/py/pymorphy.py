import pymorphy2
import argparse

def enter_word(text):
    morph = pymorphy2.MorphAnalyzer()
    word = morph.parse(text)

    wordlist = list({norm.normalized for el in word for norm in el.lexeme})

    for word in wordlist:
        print("word: ", word.normal_form, "\ntags: ", word.tag.cyr_repr)
        for el in word.lexeme:
            print(el.word)
        print('------')

if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('--text', type=str)
    args = parser.parse_args()
    enter_word(args.text)
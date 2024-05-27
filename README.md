# BabyStepsGolf

![A close up photo of a golf ball on a golf green. Generated by AI](images/ai-generated-golf.jpg) <br>
"[AI Generated Golf](https://pixabay.com/fr/illustrations/ai-g%C3%A9n%C3%A9r%C3%A9-le-golf-balle-8441650/)" by [Ray Shrewsberry](https://pixabay.com/fr/users/ray_shrewsberry-7673058/) is licenced under [Pixabay License](https://pixabay.com/fr/service/license-summary/)

## Description

_Let's see how many baby steps you need to solve this problem!_

## Getting Started

- [C++](cpp/GETTING_STARTED.md)
- [C#](csharp/GETTING_STARTED.md)
- [Elixir](elixir/GETTING_STARTED.md)
- [Go](go/GETTING_STARTED.md)
- [Java](java/GETTING_STARTED.md)
- [PHP](php/GETTING_STARTED.md)
- [Python](python/GETTING_STARTED.md)
- [Rust](rust/GETTING_STARTED.md)
- [Typescript](typescript/GETTING_STARTED.md)

## Session Quick Retrospective

You can fill it from [here](QuickRetrospective.md)

## Useful Links

### For this Kata

- Catalog of refactoring:
  - https://refactoring.com/catalog
  - https://refactoring.guru/refactoring/catalog
- Catalog of Transformations:
  - https://en.wikipedia.org/wiki/Transformation_Priority_Premise
  - original article: https://blog.cleancoder.com/uncle-bob/2013/05/27/TheTransformationPriorityPremise.html
- SPIDR Story Splitting:
  - https://www.mountaingoatsoftware.com/uploads/blog/spidr-poster.pdf

### General

- [TCR (Test && Commit || Revert) wrapper](tcr/TCR.md) utility
- Collaborative timer for pairing or mobbing:
  [mobti.me](https://mobti.me/)
  or [agility timer](https://agility.jahed.dev/)

## Session Information

### Topic

_The goal of this kata is to practice updating working software with the smallest number of baby steps possible!_

### Focus Points

- Understanding what we call a "baby step"
- Awareness that baby steps have names
- Understanding the difference between Refactoring (that preserve behaviour) and Transformative (that change behaviour) baby steps.
- Learning to separate 'design' and 'feature' work
- Understand how baby-steps support continuous refactoring within user stories
- Understand how baby-steps support user story splitting that maximizes early value delivery

### Style & Duration

This kata is best played like a golf track. It consists of 3 "holes", which are features to add to existing working software.
Like golf holes, each feature has a 'par': a typical number of baby steps it can be implemented with. 
You might do better than the par, or worse. You can replay a hole to reduce your number of baby steps.
Using TCR helps us to keep track of the number of baby steps.

You can practice using either of these styles:

- 2-hour [Prepared Kata](doc/PreparedKata.md)
- 2-hour [Randori in Pairs](doc/RandoriInPairs.md)
- 2-hour [Randori Kata](doc/RandoriKata.md)
- 2-hour [Mob Kata](doc/MobProgramming.md)

If pairs commit and push using TCR on their own branch, the facilitator can even keep track of their progress and create a leaderboard!

### Holes

#### 1: Pascal Triangle

- **User Story**: As a math geek, I want to make the triangle display isosceles, so that it looks more like the traditional image we have of Pascal's Triangle
- **Difficulty**: Easy
- **Par**: TODO
- **SPIDR Story Splitting by**: INTERFACES, baby steps programming let us safely postpone improvements to the display, while letting users enjoy a working yet minimalistic display early
- **Attention Point**:
  - TODO

#### 2: FizzBuzz

- **User Story**: As a birthday party organizer, I want to add "Bazz" for multiples of 7, so that I have a more difficult game for experienced FizzBuzz players
- **Difficulty**: Medium
- **Par**: 16 TODO check
- **SPIDR Story Splitting by**: RULES, baby steps programming let us safely postpone more advanced rules, while letting players enjoy a working fun game early
- **Attention Point**:
  - Introduce an accumulator
  - TODO

#### 3: Numbers to LCD

- **User Story**: As a giant display panel operator, I need to specify a size for the LCD display, so that I can display details in small text
- **Difficulty**: Difficult
- **Par**: TODO
- **SPIDR Story Splitting by**: DATA, baby steps programming let us safely postpone the less used cases, while letting users use a working display on the most frequent input early
- **Attention Point**:
  - TODO

### Source Files

- [C++](cpp)
- [C#](csharp)
- [Elixir](elixir)
- [Go](go)
- [Java](java)
- [PHP](php)
- [Python](python)
- [Rust](rust)
- [Typescript](typescript)

## License

`Kata-BabyStepsGolf` and the accompanying materials are made available
under the terms of the [MIT License](LICENSE.md) which accompanies this
distribution, and is available at the [Open Source site](https://opensource.org/licenses/MIT)

## Acknowledgements

See [ACKNOWLEDGEMENTS.md](ACKNOWLEDGEMENTS.md) for more information.

## Contributors

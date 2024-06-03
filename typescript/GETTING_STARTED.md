# Getting Started with BabyStepsGolf kata in Typescript

## Prerequisites

- macOS, Linux or Windows
- [git](https://git-scm.com/) client
- [curl](https://curl.se/download.html) command line utility
- [node](https://nodejs.org/en/download)
- [yarn](https://classic.yarnpkg.com/lang/en/docs/install)
  <details><summary>Details</summary>

  You can install node directly or through nvm.

  </details>

## Getting ready

### 1 - Clone the kata repository

```shell
git clone https://github.com/murex/Kata-BabyStepsGolf.git
```

### 2 - Go to the kata's `typescript` directory

```shell
cd Kata-BabyStepsGolf/typescript
```

### 3 - Download dependencies

```shell
yarn install
```

## Running the kata

You can run the kata from the command line or from your IDE of choice.

You may also run it using "Golf TCR" if you want to add a bit of spice.

- [From a terminal with Yarn](#running-the-kata-from-a-terminal-with-yarn)
- [From a terminal with Golf TCR](#running-the-kata-from-a-terminal-with-golf-tcr)

<a name="running-the-kata-from-a-terminal-with-yarn"/></a>

### Running the kata from a terminal with Yarn

> ***Reminder***: the command below should be run from [Kata-BabyStepsGolf/typescript](.) directory

The kata comes with a Yarn test target pre-configured. Just type the following to run it.

```shell
yarn test
```

<a name="running-the-kata-from-a-terminal-with-golf-tcr"/></a>

### Running the kata from a terminal with Golf TCR

> ***Note to Windows users***
> 
> Use a **git bash** terminal for running the command below.
> _Windows CMD and PowerShell are not supported_

Type the following to run TCR:

```shell
./golf-tcr.sh style "no change" "Did not change anything!"
```

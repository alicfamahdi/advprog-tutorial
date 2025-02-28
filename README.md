# advprog-tutorial
Name: Aliefa Alsyafiandra Setiawati Mahdi
\
NPM: 2306221036
\
Class: Advanced Programming A

## Tutorial 1
<html lang="en">
<details>
<summary>Reflection 1</summary>
You already implemented two new features using Spring Boot. Check again your source code and evaluate the coding standards that you have learned in this module. Write clean code principles and secure coding practices that have been applied to your code.  If you find any mistake in your source code, please explain how to improve your code. Please write your reflection inside the repository's README.md file.

- Coding standards that I have learned in this module are clean and secure coding practices, code testing such as unit tests and functional tests, as well as team workflows using git.

- For clean code practices, I have applied meaningful and clear names for variables and methods.
  Methods are also made for specific functions and only do one thing.
  There are little to no comments as the names given should already be sufficiently self-explanatory.

- As for secure coding practices, I have not applied any, because the program is still for testing purposes and is still very simple.
  However, I definitely would try to implement more secure practices for bigger projects.
</details>

<details>
<br>
<summary>Reflection 2</summary>
1. After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors?

- I feel half satisfied with the program and the tests I made for it, but they could definitely be improved.
- The amount of tests that should be made in a class depends on the number of methods there are.
Then each method should have several positive and negative scenarios, depending on how complex the method is.
- If I had 100% code coverage, that wouldn't necessarily mean that my code has no bugs or errors.
This is because code coverage focuses on the lines of code that are tested for, but not for every possible scenario.

2. Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables.
What do you think about the cleanliness of the code of the new functional test suite? Will the new code reduce the code quality? Identify the potential clean code issues, explain the reasons, and suggest possible improvements to make the code cleaner! Please write your reflection inside the repository's README.md file.
- Though writing more tests is a good thing, it can definitely be more efficient.
The code will be less clean, as we are repeating ourselves just to test one functionality.
Because the program is still very simple, I would suggest having only one functional test suite for all the pages.
Still, for more complex programs, I'd probably suggest making a functional test suite for each page, if necessary.
</details>
</html>

## Tutorial 2
<html lang="en">
<details>
<summary>Reflection 1</summary>
You have implemented a CI/CD process that automatically runs the test suites, analyzes code quality, and deploys to a PaaS.
Try to answer the following questions in order to reflect on your attempt completing the tutorial and exercise.

1. List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.
Look at your CI/CD workflows (GitHub)/pipelines (GitLab).
- Issues with my code quality are as follows:
>1. Make the enclosing method "static" or remove this set.
>- In the Product class, I made a method for setting product IDs,
>and it used a static attribute. 
>In actuality, ideally, static fields are only updated from synchronized static methods.
>To solve this problem, I removed the method and static attribute,
>replacing it with a random UUID assignment in the product repository for each product's ID.
>2. Anchor tags should not be used as buttons.
>- For the product list page, initially, I used anchor tags for buttons.
>However, I realize there are several issues when using anchor tags as buttons,
>one of which is that it's less accessible for users that use screen readers and other assistive technologies
>that rely on the correct use of HTML, among others.
>3. Add a nested comment explaining why this method is empty, throw an UnsupportedOperationException or complete the implementation.
>- To solve this problem, I removed the empty methods, as they are of no use yet.

There are also other minor problems, such as unnecessary public modifiers, unused imports,
and ungrouped dependencies. I have solved them by deleting lines and moving lines around to make it more neat and maintainable.
2. Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment?
Explain the reasons (minimum 3 sentences)!
- By definition, Continuous Integration (CI) is “a software development practice where continuous changes & updates in codebase are integrated and verified by an automated build script using various tools.” (Swaraj, 2017).
- Meanwhile, Continuous Deployment (CD) is "also a software development practice. Its role is to automatically deploy the code to the application folder on the specified server" (Swaraj, 2017).
- By CI perspectives, I do think I have already implemented it quite nicely for what is required; continuous changes and updates have automated build scripts: ci.yml, scorecard.yml, and sonarcloud.yml that verifies the code for every push I make to GitHub.
- Furthermore, for the CD part, I have set up a Koyeb deployment, where it will automatically redeploy for every push to GitHub.

Safe to say, in my own opinion, I do think the current implementation already fits the very basis of the definitions for CI/CD.
</details>
</html>

## Tutorial 3
<html lang="en">
<details>
<summary>Reflection 1</summary>
Apply the SOLID principles you have learned.
You are allowed to modify the source code according to the principles you want to implement.
Please answer the following questions: 
1. Explain what principles you apply to your project!
\
I tried to apply OO principles, especially SOLID, which stands for Single Responsibility Principle (SRP),
Open-Closed Principle (OCP), Liskov Substitution Principle (LSP), Interface Segregation Principle (ISP),
and Dependency Inversion Principle (DIP). 
- SRP is a class that has only one reason to change. In other words, a class should have only one responsibility or encapsulate only one aspect of the software's functionality.
- OCPs are software entities (classes, modules, functions, etc.) that should be open for development but closed for modification.
- LSP is an object from the superclass that must be replaced with an object from the subclass without affecting the correctness of the program. In other words, subclasses must be replaceable with their base class without changing desired program properties, such as correctness and consistency.
- ISPs recommend that large interfaces be broken down into smaller, more specific interfaces so that clients only need to know the methods that are relevant to them.
- DIP recommends that high-level modules do not depend on low-level modules. Both must rely on abstractions. Additionally, abstraction should not depend on details; details must rely on abstraction.

2. Explain the advantages of applying SOLID principles to your project with examples.
\
The advantages of applying SOLID are the reusability of my code. For example, with ISP, 
interfaces should be specific so that a class that implements that interface shouldn't be
burdened with methods that they do not need.
3. Explain the disadvantages of not applying SOLID principles to your project with examples.
\
I experienced the disadvantages of not applying SOLID principles myself, which was that the
code was not as portable as it could be.
For example, there used to be specific Service classes for models Car and Product. However,
they had very similar methods, and it would be much better if they both implemented one same
interface. This interface could then be used for newer models later on.
</details>
</html>

[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=alicfamahdi_advprog-tutorial&metric=coverage)](https://sonarcloud.io/summary/new_code?id=alicfamahdi_advprog-tutorial)
\
[Alie's ADVShop](https://vague-mallissa-alicfamahdi-e0395449.koyeb.app/)


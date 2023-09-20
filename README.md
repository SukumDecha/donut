# Donut - Challenge

## Class Structure

- `DEFAULT_THICKNESS`: Create a default minimum thickness of the donut, set to `3.0`.

## Private Fields

- `inner`: A private field representing the inner circle.
- `outer`: A private field representing the outer circle.

## Constructors

- `constructor (inner radius, outer radius)`: The main constructor.
- `constructor (inner radius)`: A constructor that delegates to the main constructor, using the provided inner radius and default outer radius.
- `constructor ()`: A constructor that delegates to the main constructor, using default inner and outer radii.

## Methods

- `getInnerRadius()`: Get the inner radius of the donut.
- `getOuterRadius()`: Get the outer radius of the donut.
- `getThickness()`: Get the thickness of the donut.
- `setInnerRadius(inner radius)`: Set the inner radius of the donut and use the old outer radius. Returns `false` if the operation fails.
- `setOuterRadius(outer radius)`: Set the outer radius of the donut and use the old inner radius. Returns `false` if the operation fails.
- `setThickness(thickness)`: Set the thickness of the donut and use the old inner radius. Returns `false` if the operation fails.
- `computeArea()`: Calculate and return the area of the donut.
- `toString()`: Return a string representation of the donut in the format "Donut(inner radius, outer radius)".

```markdown
Example:
Donut(5.0, 8.0)

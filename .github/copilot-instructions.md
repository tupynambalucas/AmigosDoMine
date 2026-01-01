# Copilot Instructions for AmigosDoMine

## Project Overview

This is a monorepo containing:

- **Backend**: NestJS API with TypeScript
- **Frontend**: React + Vite with TypeScript
- **Shared**: Shared TypeScript utilities and types
- **Minecraft**: Minecraft server resources

## Code Style & Conventions

### TypeScript/JavaScript

- Use `const` by default, `let` only when necessary
- Always use explicit type annotations
- Follow ESLint and Prettier configurations
- Use relative imports within packages
- Use camelCase for variables and functions
- Use PascalCase for classes and types

### File Organization

```
src/
  components/     # React components (if frontend)
  domains/        # Feature domains
  types/          # TypeScript types
  utils/          # Utility functions
  config/         # Configuration
  models/         # Database/API models
```

### React Best Practices (Frontend)

- Use functional components with hooks
- Keep components small and focused
- Use React Query for data fetching
- Export components as default exports

### NestJS Best Practices (Backend)

- Use modules to organize features
- Create DTOs for request/response validation
- Use dependency injection for services
- Follow the controller → service → repository pattern

## Testing

- Write unit tests for business logic
- Use Jest as the test runner
- Aim for 80%+ code coverage
- Name test files as `*.spec.ts`

## Documentation

- Add JSDoc comments for exported functions
- Document complex algorithms
- Keep README.md files in each package updated

## Git & Commits

- Use conventional commits: `feat:`, `fix:`, `docs:`, `refactor:`, `test:`, `chore:`
- Write clear, descriptive commit messages
- Keep commits small and focused

## Common Commands

- `npm install` — install dependencies (root)
- `npm run build` — build all packages
- `npm run dev` — start development servers
- `npm run lint` — lint all packages
- `npm run format` — format code with Prettier

## DO NOT

- Modify Minecraft server files unless necessary
- Commit `node_modules` or build artifacts
- Use `any` type without explicit justification
- Create circular dependencies between packages

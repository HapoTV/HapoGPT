# HAPO GPT

AI-powered cultural intelligence and business analytics platform.

HAPO GPT is a scalable AI-driven business intelligence platform that combines conversational AI, cultural analytics, behavioral insights, and real-time trend analysis to help organizations make smarter marketing and business decisions.

---

# Project Overview

HAPO GPT enables businesses, brands, organizations, and institutions to interact with analytics using natural language conversations similar to ChatGPT while receiving intelligent recommendations powered by cultural and consumer behavior data.

The platform provides:

- AI conversational analytics
- Audience intelligence
- Cultural trend analysis
- Recommendation systems
- Location-based insights
- Real-time business intelligence
- Interactive dashboards

---

# Technology Stack

## Frontend Web

- React
- TypeScript
- Vite
- Tailwind CSS
- React Router
- TanStack Query
- Axios
- Shadcn/UI

## Mobile Application

- React Native
- Expo
- TypeScript
- React Navigation
- NativeWind

## Backend

- Java
- Spring Boot
- Spring Security
- JWT Authentication
- REST APIs

## Database & Services

- Supabase PostgreSQL
- Supabase Storage
- Supabase Realtime
- Supabase Authentication

## External APIs

- Qloo API

## DevOps & Deployment

- GitHub Actions
- Vercel
- Railway / Render / Google Cloud Run
- Google Play Console
- Apple App Store

---

# Monorepo Structure

```txt
hapo-gpt/
│
├── apps/
│   ├── web/                  # React Web Application
│   ├── mobile/               # React Native Mobile Application
│   └── backend/              # Spring Boot Backend
│
├── packages/
│   ├── shared-types/         # Shared TypeScript types
│   ├── api-client/           # Shared API client
│   ├── ui/                   # Shared UI components
│   ├── utils/                # Shared utilities
│   └── config/               # Shared configurations
│
├── docs/                     # Documentation
├── assets/                   # Shared assets
├── scripts/                  # Automation scripts
├── .github/                  # CI/CD workflows
│
├── package.json
├── turbo.json
├── pnpm-workspace.yaml
└── README.md
```

## System Architecture

```
Frontend Web (React)
        ↓
Frontend Mobile (React Native)
        ↓
Backend API (Spring Boot)
        ↓
Supabase PostgreSQL Database
        ↓
External APIs (Qloo API)
```

---

# Core Features

## AI Conversational Interface
- Natural language interaction
- AI-generated responses
- Conversational analytics
- Human-friendly reporting

## Audience Intelligence
- Audience behavior analysis
- Interest tracking
- Lifestyle patterns
- Behavioral signals

## Cultural Insights
- Entertainment trends
- Lifestyle analysis
- Local culture monitoring
- Event analysis

## Trend Analysis
- Real-time trend tracking
- Forecasting
- Behavioral analytics
- Industry trends

## Recommendation Engine
- Audience targeting suggestions
- Advertising recommendations
- Content recommendations
- Strategic insights

## Dashboard & Analytics
- Interactive dashboards
- Charts and graphs
- KPI tracking
- Analytics summaries

---

# Frontend Scope

## Web Application Pages
- Landing Page
- Login Page
- Registration Page
- Dashboard
- Insights Page
- Trend Analysis Page
- Audience Intelligence Page
- Recommendations Page
- Reports Page
- Settings Page
- Admin Dashboard

## Frontend Features
- Responsive UI
- AI chat interface
- Interactive dashboards
- Data visualizations
- Authentication
- Notifications
- Search and filtering
- Real-time updates

---

# Mobile Application Scope

## Mobile Features
- Authentication
- AI chat access
- Insight summaries
- Notifications
- Trend alerts
- Personalized recommendations
- Dashboard overview
- Saved reports

---

# Backend Responsibilities

- Authentication & authorization
- API management
- Qloo API integration
- Recommendation engine
- Analytics processing
- Business logic
- Security implementation
- Logging & monitoring

## Backend Modules

### Authentication Module
- Login
- Registration
- JWT token management
- Password encryption

### User Management Module
- User profiles
- Roles & permissions
- Account settings

### Insights Module
- Trend analysis
- Behavioral analytics
- Audience insights

### Recommendation Engine
- AI recommendations
- Audience targeting
- Location suggestions

### Qloo Integration Module
- API communication
- Data transformation
- Error handling
- Response caching

---

# Database Tables

## Users
Stores:
- User information
- Authentication details
- Roles
- Preferences

## Insights
Stores:
- Trend data
- Analytics results
- AI-generated insights

## Recommendations
Stores:
- Personalized recommendations
- Targeting suggestions

## Conversations
Stores:
- AI chat history
- User prompts
- AI responses

## Reports
Stores:
- Analytics reports
- Export history
- Generated summaries

---

# Security

## Authentication
- JWT Authentication
- Secure login
- Password encryption
- Session management

## Data Security
- HTTPS encryption
- Secure API communication
- Protected database access
- Environment variable protection

## Access Control
- Role-based access
- Admin permissions
- User authorization

---

# Development Setup

## Requirements

Install:
- Node.js
- Java JDK 21+
- pnpm
- Expo CLI
- Git

## Clone Repository

```bash
git clone <repository-url>
cd hapo-gpt
```

## Install Dependencies

```bash
pnpm install
```

## Run Frontend Web

```bash
cd apps/web
pnpm dev
```

## Run Mobile App

```bash
cd apps/mobile
npx expo start
```

## Run Backend

```bash
cd apps/backend
./mvnw spring-boot:run
```

---

# Environment Variables

Create `.env`

Example:

```env
VITE_SUPABASE_URL=
VITE_SUPABASE_ANON_KEY=

SPRING_DATASOURCE_URL=
SPRING_DATASOURCE_USERNAME=
SPRING_DATASOURCE_PASSWORD=

QLOO_API_KEY=
JWT_SECRET=
```

---

# Branching Strategy

## Main Branches
- `main`
- `develop`

## Feature Branches
- `feature/frontend-*`
- `feature/mobile-*`
- `feature/backend-*`

---

# Project Timeline

## Duration
8 Weeks

## Milestones

### Week 1
- Project setup
- Architecture planning
- Figma designs
- Environment setup

### Week 2
- Authentication system

### Week 3
- AI chat integration
- Qloo integration

### Week 4
- Insights & recommendations

### Week 5
- Dashboards & analytics

### Week 6
- UI/UX optimization

### Week 7
- Testing & integration

### Week 8
- Deployment & finalization

---

# Contributors

Hapo Technology Team

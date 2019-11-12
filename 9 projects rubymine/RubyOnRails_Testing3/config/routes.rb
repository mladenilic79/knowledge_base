# routes capture the path of page hit by the user & pass it
# to the controller, i.e. specified controller action

Rails.application.routes.draw do

  # For details on the DSL available within this file, see https://guides.rubyonrails.org/routing.html

  # books       GET    /books(.:format)             books#index
  #             POST   /books(.:format)             books#create
  # new_book    GET    /books/new(.:format)         books#new
  # edit_book   GET    /books/:id/edit(.:format)    books#edit
  # book        GET    /books/:id(.:format)         books#show
  #             PATCH  /books/:id(.:format)         books#update
  #             PUT    /books/:id(.:format)         books#update
  #             DELETE /books/:id(.:format)         books#destroy

  # resources keyword gives all methods in controller (return all routes with $ rake routes)
  resources :children
  resources :parents
  resources :authors
  resources :themes
  resources :blogs

  # alternatively if you have special cases you can remove methods from default resources & do them separately
  # resources :blogs, except: [:show, :index, :new]

  # any parameter that will be expected will be prefixed with : like :id here
  # get 'blogs/:id', to: 'blogs#show'

  # alternatively use as to change naming to second portion of command to change rake routes prefix
  # change prefix only
  # get 'blogs/:id/edit', to: 'blogs#edit', as: 'blogs_edit_now'

  # alternatively declare link name ('about') to 'controller/action' ('pages#about')
  # change prefix & change link
  # get 'blog_create_new', to: 'blogs#new'

  # or alternatively set root of the application to the 'controller/action' ('pages/home'),
  # access with <<localhost:3000>>, this changes list on rake routes
  # root to: 'blogs#index'

  # all manual for books here as default with resources made (link, controller#action, prefix)
  get 'books', to: 'books#index', as: 'books'
  post 'books', to: 'books#create'
  get 'books/new', to: 'books#new', as: 'new_book'
  get 'books/:id/edit', to: 'books#edit', as: 'edit_book'
  get 'books/:id', to: 'books#show', as: 'book'
  patch 'books/:id', to: 'books#update'
  put 'books/:id', to: 'books#update'
  delete 'books/:id', to: 'books#destroy'

  # showcase static method & scopes instead of parameter in controller
  # (routes, models/blogs, controller/blogs_controller, views/custom_methods_from_model)
  get 'methods', to: 'blogs#custom_methods_from_model'

  # static pages, means no model, just view, rails looks for basicly 'controller/action'
  # (routes, controller/pages_controller, views/pages)
  get 'pages/home'
  get 'pages/about'
  # or
  # get 'pages/home', to: 'pages#home'
  # get 'pages/about', to: 'pages#about'

  # if used *missing (joker) any inputed link will be redirected to specified view
  get 'blogs/*missing', to: 'blogs#missing'
  get '*missing', to: 'missing#missing'
  # add also method missing in specified controller, also add view in specified directory in views,
  # puts *missing route last down the page so to not get unwanted redirections

=begin
  devise_for :users
  # alternatively see below
  namespace :random_directory do
    get 'random_named/main'
    get 'random_named/user'
    get 'random_named/blog'
  end
  # if used this contruction means that
  # <<random_named>> controller class must be nested inside a <<random_directory>> directory &
  # must have a prefix in class name like this <<random_directory::random_named>>,
  # there also must be nested like this in <<random_directory>> directory in views also,
  # so put <<random_named>> views directory inside newly created <<random_directory>> directory in views
  # alternatively change link paths to custom
  devise_for :users, path: '', path_names: { sign_in: 'login', sign_out: 'logout', sign_up: 'register' }

  # alternatively do block implementing toggle system ?????????????????????????????
  resources :blogs do
    member do
      get :toggle_status
    end
  end
=end

end

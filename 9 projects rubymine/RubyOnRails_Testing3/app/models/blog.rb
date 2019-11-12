# model gives us direct connection to the database

class Blog < ApplicationRecord

  # validation, returns error if incomplete for database entry, add manually if needed not mandatory
  validates_presence_of :blog_name, :blog_number

  # connectiong database tables (after adding foreign key with command)
  belongs_to :parent
  has_many :children

  # many to many relationships:
  # authors model would say:
  # has_many :books
  # has_many :genres, through :books
  # genres model would say:
  # has_many :books
  # has_many :authors, through: :books
  # where the books is connection table/model

  # alternatively on delete also delete all dependants
  # has_many :technologies, dependant: :destroy
  # has many :technologies, dependent: :restrict_with_error

  # showcase static method & scopes instead of parameter in controller
  # (routes, models/blogs, controller/blogs_controller, views/custom_methods_from_model)
  def self.static_method_from_model
    where(blog_name: 'my random name')
    # or for example
    # limit(2)
  end
  # also instead of parameter in controller with lambda scope
  # defines orm methods for querying database (parentheses optional)
  scope :scope_blogs_by_name, -> { where(blog_name: 'my random name') }
  # can pass parameters
  scope :scope_blogs_by_parent_id, ->(id) { where parent_id: id }

  # after items has been initialized (after method new is called) run specified method
  after_initialize :model_instance_method_setting_value

  # adding methods from model concern
  # include keyword add methods to this class to be used as needed
  include ModelConcern

  # static members

  # static value
  @@model_static_value = 5
  # instance method for setting default
  def model_instance_method_setting_value
    @@model_static_value = 10
  end
  # static method for setting default
  def self.model_static_method_setting_value
    @@model_static_value = 20
  end

  # generic static method
  def self.model_static_method
    "i am model static method"
  end

=begin
  # devise gem (see models/user for example)

  # added status field enum to model to manage data stages, rails automaticaly
  # creates state machine here, db query scopes & custom methods
  # every blog post will be draft by default until published
  enum status: { draft: 0, published: 1 }

  # title is title of the blog which will be used for permalinks
  # (see instructions for adding permalinks)
  extend FriendlyId
  friendly_id :title, use: :slugged
=end

end

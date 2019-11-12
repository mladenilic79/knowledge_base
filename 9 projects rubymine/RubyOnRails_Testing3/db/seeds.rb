
# adding sample data into database

# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rails db:seed command (or created alongside the database with db:setup).
#
# Examples:
#
#   movies = Movie.create([{ name: 'Star Wars' }, { name: 'Lord of the Rings' }])
#   Character.create(name: 'Luke', movie: movies.first)

# adding sample data into database

10.times do |num|
  Parent.create!(
      parent_name: "parent name #{num}",
      parent_number: "parent number #{num}"
  )
end
puts "parents created"

10.times do |num|
  Blog.create!(
      blog_name: "blog name #{num}",
      blog_number: "blog number #{num}",
      # referencing other table
      parent_id: Parent.last.id
  )
end
puts "blogs created"

10.times do |num|
  Blog.create!(
      blog_name: "my random name",
      blog_number: "blog number #{num}",
      # referencing other table
      parent_id: Parent.last.id
  )
end
puts "blogs created"

10.times do |num|
  Child.create!(
      child_name: "child name #{num}",
      child_number: "child number #{num}",
      # referencing other table
      blog_id: Blog.last.id
  )
end
puts "children created"

10.times do |num|
  Author.create!(
      author_name: "author name #{num}",
      author_number: "author number #{num}"
  )
end
puts "authors created"

10.times do |num|
  Theme.create!(
      theme_name: "theme name #{num}",
      theme_number: "theme number #{num}"
  )
end
puts "themes created"

10.times do |num|
  Book.create!(
      book_name: "book name #{num}",
      book_number: "book number #{num}",
      # referencing other tables
      author_id: Author.last.id,
      theme_id: Theme.last.id
  )
end
puts "books created"

=begin
10.times do |num|
  ScaffoldTest1.create!(
      test_name: "test name #{num}",
      test_number: "test number #{num}"
  )
end
puts "scaffold_test_1s created"
=end
